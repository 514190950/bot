package com.zhonghaiwenda.gitlab.bot.model.webhook.event;


import lombok.Data;


/**
 * @author gxz
 */
@Data
public class EventSnippet {

    private Integer id;
    private String title;
    private String content;
    private Integer authorId;
    private Integer projectId;
    private String createdAt;
    private String updatedAt;
    private String fileName;
    private String expiresAt;
    private String type;
    private int visibilityLevel;


}
