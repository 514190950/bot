package com.zhonghaiwenda.gitlab.bot.handle.root.dispatch;


import com.zhonghaiwenda.gitlab.bot.handle.RootDispatch;
import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.NoteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gxz
 * @date 2021/2/9 16:46
 * 所有和comment相关的事件由此实例分发
 */
@Component
public class CommentDispatch implements RootDispatch<NoteEvent> {

    @Autowired
    private List<RootHandle<NoteEvent>> eventHandles;


    @Override
    public void dispatch(NoteEvent event) {
        RootHandle<NoteEvent> noteEventEventHandle = checkHandle(event);
        if(noteEventEventHandle != null){
                noteEventEventHandle.accept(event);
        }
    }

    private RootHandle<NoteEvent> checkHandle(NoteEvent event){
        for (RootHandle<NoteEvent> eventHandle : eventHandles) {
            if(eventHandle.supportAction(event)){
                return eventHandle;
            }
        }
        return null;
    }

    @Override
    public Class<NoteEvent> supportEvent() {
        return NoteEvent.class;
    }
}
