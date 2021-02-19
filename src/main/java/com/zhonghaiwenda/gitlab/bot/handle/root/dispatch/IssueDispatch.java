package com.zhonghaiwenda.gitlab.bot.handle.root.dispatch;


import com.zhonghaiwenda.gitlab.bot.handle.EventHandle;
import com.zhonghaiwenda.gitlab.bot.handle.RootDispatch;
import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.IssueEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gxz
 * @date 2021/2/9 16:46
 */
@Component
public class IssueDispatch implements RootDispatch<IssueEvent> {


    @Autowired
    private List<RootHandle<IssueEvent>> eventHandleList;


    @Override
    public void dispatch(IssueEvent event) {
        RootHandle<IssueEvent> handle = getHandle(event);
        if (handle != null) {
            handle.accept(event);
        }
    }

    private RootHandle<IssueEvent> getHandle(IssueEvent event) {
        for (RootHandle<IssueEvent> issueEventEventHandle : eventHandleList) {
            if (issueEventEventHandle.supportAction(event)) {
                return issueEventEventHandle;
            }
        }
        return null;
    }

    @Override
    public Class<IssueEvent> supportEvent() {
        return IssueEvent.class;
    }


}
