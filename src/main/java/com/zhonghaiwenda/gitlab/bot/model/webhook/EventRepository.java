package com.zhonghaiwenda.gitlab.bot.model.webhook;

import lombok.Data;

/**
 * @author gongxuanzhang
 */
@Data
public class EventRepository {

    private String name;
    private String url;
    private String description;
    private String homepage;
}
