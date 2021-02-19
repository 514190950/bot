package com.zhonghaiwenda.gitlab.bot.handle.systemhandle;

import com.zhonghaiwenda.gitlab.bot.handle.EventHandle;
import com.zhonghaiwenda.gitlab.bot.handle.root.handle.IssueUpdateHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.IssueEvent;
import com.zhonghaiwenda.gitlab.bot.util.CommentProcessExecute;
import com.zhonghaiwenda.gitlab.bot.util.Constant;
import com.zhonghaiwenda.gitlab.bot.util.IssueProcessExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author gxz
 * 实例处理Issue被指派给某人的事件
 */
@Component
public class IssueAssigneeHandle implements EventHandle<IssueEvent, IssueUpdateHandle> {


    @Override
    public void handle(IssueEvent event) {
        IssueAttribute objectAttributes = event.getObjectAttributes();
        new IssueProcessExecute(objectAttributes).removeTags(Collections.singletonList(Constant.WAIT_ASSIGNEE)).execute();
        new IssueProcessExecute(objectAttributes).addTags(Collections.singletonList(Constant.WAIT_RESOLVE)).execute();
        String username = event.getChanges().getAssignees().getCurrent().get(0).getUsername();
        String body = "此问题被分配给了 @"+username+" 等待解决";
        CommentProcessExecute.commentIssue(objectAttributes.getProjectId(),objectAttributes.getIid(),body);
    }

    @Override
    public boolean support(IssueEvent event) {
        return event.getChanges().getAssignees()!=null;
    }
}
