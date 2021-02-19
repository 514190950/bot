package com.zhonghaiwenda.gitlab.bot.model.webhook.event;

import com.zhonghaiwenda.gitlab.bot.model.user.Author;
import lombok.Data;

import java.util.List;

/**
 * @author gxz
 */
@Data
public class EventCommit {

    private String id;
    private String message;
    private String timestamp;
    private String url;
    private Author author;
    private List<String> added;
    private List<String> modified;
    private List<String> removed;


}
