package com.zhonghaiwenda.gitlab.bot.model.webhook.event;

import com.zhonghaiwenda.gitlab.bot.model.user.Assignee;
import com.zhonghaiwenda.gitlab.bot.model.webhook.IssueChanges;
import com.zhonghaiwenda.gitlab.bot.model.user.User;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventLabel;
import com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventProject;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventRepository;
import lombok.Data;

import java.util.List;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/

@Data
public class IssueEvent extends AbstractWebHookEvent {

    private String objectKind;
    private String eventType;
    private User user;
    private EventProject project;
    private IssueAttribute objectAttributes;
    private EventRepository repository;
    private IssueChanges changes;
    private List<EventLabel> labels;
    private List<Assignee> assignees;
    private Assignee assignee;


}
