package com.zhonghaiwenda.gitlab.bot.handle.root.handle;

import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.MergeRequestEvent;
import com.zhonghaiwenda.gitlab.bot.util.EventUtils;
import org.springframework.stereotype.Component;


import static com.zhonghaiwenda.gitlab.bot.model.webhook.event.MergeRequestEvent.MergeRequest.open;

/**
 * @author gxz
 * 实例处理创建MergeRequest的事件
 * 在刚创建一个mr的时候   把相关联解决的issue变成等待测试
 */
@Component
public class MergeRequestOpenHandle implements RootHandle<MergeRequestEvent> {


    @Override
    public boolean supportAction(MergeRequestEvent event) {
        return event.getObjectAttributes().getAction() == open;
    }

    @Override
    public void accept(MergeRequestEvent event) {
        String description = event.getObjectAttributes().getDescription();
        EventUtils.resolveIssue(null, description, event.getProject().getId(),event.getObjectAttributes().getIid());
    }
}
