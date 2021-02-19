package com.zhonghaiwenda.gitlab.bot.handle.root.dispatch;


import com.zhonghaiwenda.gitlab.bot.handle.RootDispatch;
import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.MergeRequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author gxz
 * @date 2021/2/9 16:46
 * 所有和mergeRequest相关的事件由此实例分发
 */
@Component
public class MergeRequestDispatch implements RootDispatch<MergeRequestEvent> {



    @Autowired
    private List<RootHandle<MergeRequestEvent>> rootHandleList;



    @Override
    public void dispatch(MergeRequestEvent event) {
        RootHandle<MergeRequestEvent> mergeRequestEventRootHandle = checkHandle(event);
        if (mergeRequestEventRootHandle != null) {
            mergeRequestEventRootHandle.accept(event);
        }
    }

    private RootHandle<MergeRequestEvent> checkHandle(MergeRequestEvent event) {
        for (RootHandle<MergeRequestEvent> mergeRequestEventRootHandle : rootHandleList) {
            if (mergeRequestEventRootHandle.supportAction(event)) {
                return mergeRequestEventRootHandle;
            }
        }
        return null;
    }

    @Override
    public Class<MergeRequestEvent> supportEvent() {
        return MergeRequestEvent.class;
    }
}
