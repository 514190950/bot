package com.zhonghaiwenda.gitlab.bot.model.webhook.event;


import com.zhonghaiwenda.gitlab.bot.model.webhook.Commit;
import com.zhonghaiwenda.gitlab.bot.model.user.User;
import com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventProject;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventRepository;
import lombok.Data;

/**
 * @author gxz
 * @date 2021/2/8 14:58
 */
@Data
public class Comment implements Event {

    private String objectKind;
    private User user;
    private int projectId;
    private EventProject project;
    private EventRepository repository;
    private IssueAttribute objectAttributes;
    private Commit commit;


}
