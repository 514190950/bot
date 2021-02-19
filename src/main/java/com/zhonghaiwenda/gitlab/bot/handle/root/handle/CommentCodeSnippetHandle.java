package com.zhonghaiwenda.gitlab.bot.handle.root.handle;

import com.zhonghaiwenda.gitlab.bot.handle.EventHandle;
import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.NoteEvent;
import org.springframework.stereotype.Component;

/**
 * @author gxz
 * 实例处理评论代码模板的事件
 */
@Component
public class CommentCodeSnippetHandle implements RootHandle<NoteEvent> {


    @Override
    public boolean supportAction(NoteEvent event) {
        return event.getObjectAttributes().getNoteableType() == NoteEvent.NoteableType.Snippet;
    }

    @Override
    public void accept(NoteEvent event) {

    }
}
