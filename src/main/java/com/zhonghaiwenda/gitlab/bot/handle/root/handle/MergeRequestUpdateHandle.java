package com.zhonghaiwenda.gitlab.bot.handle.root.handle;

import com.zhonghaiwenda.gitlab.bot.handle.EventHandle;
import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.ChangeContainer;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.MergeRequestEvent;
import com.zhonghaiwenda.gitlab.bot.util.EventUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gxz
 * 实例处理修改MergeRequest的事件
 */
@Component
public class MergeRequestUpdateHandle implements RootHandle<MergeRequestEvent> {


    @Override
    public boolean supportAction(MergeRequestEvent event) {
        return event.getObjectAttributes().getAction() == MergeRequestEvent.MergeRequest.update;
    }

    @Override
    public void accept(MergeRequestEvent event) {
        ChangeContainer<String> changeDesc = event.getChanges().getDescription();
        String previous = changeDesc.getPrevious();
        String current = changeDesc.getCurrent();
        EventUtils.resolveIssue(previous, current, event.getProject().getId(),event.getObjectAttributes().getIid());
    }
}
