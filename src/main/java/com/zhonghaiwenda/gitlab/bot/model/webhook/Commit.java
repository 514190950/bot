package com.zhonghaiwenda.gitlab.bot.model.webhook;

import com.zhonghaiwenda.gitlab.bot.model.user.User;
import lombok.Data;

/**
 * @author gongxuanzhang@foxmail.com
 */
@Data
public class Commit {
    private String id;
    private String message;
    private String timestamp;
    private String url;
    private User author;

}