package com.zhonghaiwenda.gitlab.bot.model.webhook;

import lombok.Data;

import java.time.LocalDateTime;


/**
 * @author gongxuanzhang
 */
@Data
public class EventLabel {

    private long id;
    private String title;
    private String color;
    private int projectId;
    private String createdAt;
    private String updatedAt;
    private boolean template;
    private String description;
    private String type;
    private int groupId;

}
