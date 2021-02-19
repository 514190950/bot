package com.zhonghaiwenda.gitlab.bot.handle.root.handle;

import com.zhonghaiwenda.gitlab.bot.handle.EventHandle;
import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.IssueEvent;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.MergeRequestEvent;
import com.zhonghaiwenda.gitlab.bot.util.Constant;
import com.zhonghaiwenda.gitlab.bot.util.IssueProcessExecute;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static com.zhonghaiwenda.gitlab.bot.model.webhook.event.MergeRequestEvent.MergeRequest.close;

/**
 * @author gxz
 * 实例处理MergeRequest关闭的事件
 */
@Component
public class MergeRequestCloseHandle implements RootHandle<MergeRequestEvent> {



    @Override
    public boolean supportAction(MergeRequestEvent event) {
        return event.getObjectAttributes().getAction() == close;
    }

    @Override
    public void accept(MergeRequestEvent event) {
        System.out.println("merge request 被关闭了");
    }
}
