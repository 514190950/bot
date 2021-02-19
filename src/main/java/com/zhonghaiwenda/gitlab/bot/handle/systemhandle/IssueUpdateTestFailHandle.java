package com.zhonghaiwenda.gitlab.bot.handle.systemhandle;

import com.zhonghaiwenda.gitlab.bot.handle.EventHandle;
import com.zhonghaiwenda.gitlab.bot.handle.root.handle.IssueUpdateHandle;
import com.zhonghaiwenda.gitlab.bot.model.user.Assignee;
import com.zhonghaiwenda.gitlab.bot.model.webhook.ChangeContainer;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventLabel;
import com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.IssueEvent;
import com.zhonghaiwenda.gitlab.bot.util.CommentProcessExecute;
import com.zhonghaiwenda.gitlab.bot.util.Constant;
import com.zhonghaiwenda.gitlab.bot.util.IssueProcessExecute;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author gxz
 * 当Issue被打上了测试未通过时  @当事人
 */
@Component
public class IssueUpdateTestFailHandle implements EventHandle<IssueEvent, IssueUpdateHandle> {


    @Override
    public void handle(IssueEvent event) {
        IssueAttribute objectAttributes = event.getObjectAttributes();
        List<Assignee> assignees = event.getAssignees();
        StringBuilder call = new StringBuilder();
        for (Assignee assignee : assignees) {
            call.append("@").append(assignee.getUsername()).append(" ");
        }
        new IssueProcessExecute(objectAttributes.getProjectId(),objectAttributes.getIid())
                .removeTags(Constant.excludeTag(Constant.FAIL_TEST)).execute();
        String message = call.toString()+"测试未通过，请重新关注问题";
        CommentProcessExecute.commentIssue(objectAttributes.getProjectId(),objectAttributes.getIid(),message);
    }

    @Override
    public boolean support(IssueEvent event) {
        ChangeContainer<List<EventLabel>> labels = event.getChanges().getLabels();
        return labels != null && containTag(labels.getCurrent());
    }

    private boolean containTag(List<EventLabel> current) {
        for (EventLabel eventLabel : current) {
            if (Constant.FAIL_TEST.equals(eventLabel.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
