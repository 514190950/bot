package com.zhonghaiwenda.gitlab.bot.model.user;


import lombok.Data;


/**
 * @author gongxuanzhang
 */
@Data
public abstract class AbstractUser {

    private String avatarUrl;
    private String createdAt;
    private String email;
    private Integer id;
    private String name;
    private String state;
    private String username;
    private String webUrl;

}
