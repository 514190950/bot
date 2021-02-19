package com.zhonghaiwenda.gitlab.bot.model.webhook.event;

import lombok.Data;

/**
 * @author gxz
 */
@Data
public class EventIssue {

    private Integer assigneeId;
    private Integer authorId;
    private String branchName;
    private String createdAt;
    private String description;
    private Integer id;
    private Integer iid;

    private String milestoneId;
    private Integer position;
    private Integer projectId;

    private String state;

    private String title;
    private String updatedAt;

    private String url;
    private String action;


}
