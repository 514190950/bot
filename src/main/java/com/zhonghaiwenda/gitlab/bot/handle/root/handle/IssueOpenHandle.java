package com.zhonghaiwenda.gitlab.bot.handle.root.handle;

import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.IssueEvent;
import com.zhonghaiwenda.gitlab.bot.util.CommentProcessExecute;
import com.zhonghaiwenda.gitlab.bot.util.Constant;
import com.zhonghaiwenda.gitlab.bot.util.IssueProcessExecute;
import org.springframework.stereotype.Component;

import java.util.Collections;
import static com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute.IssueAction.open;

/**
 * @author gxz
 */
@Component
public class IssueOpenHandle implements RootHandle<IssueEvent> {


    @Override
    public boolean supportAction(IssueEvent event) {
        return event.getObjectAttributes().getAction() == open;
    }

    @Override
    public void accept(IssueEvent event) {
        IssueAttribute objectAttributes = event.getObjectAttributes();
        int projectId = objectAttributes.getProjectId();
        int issueId = objectAttributes.getIid();
        new IssueProcessExecute(projectId, issueId)
                .addTags(Collections.singletonList(Constant.WAIT_ASSIGNEE))
                .execute();
        String body = "此问题刚刚创建，等待被分配";
        CommentProcessExecute.commentIssue(projectId,issueId,body);
    }
}
