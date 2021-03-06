package com.zhonghaiwenda.gitlab.bot.model.webhook;

import lombok.Data;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Data
public class EventProject {
    private int id;
    private String name;
    private String description;
    private String webUrl;
    private String avatarUrl;
    private String gitSshUrl;
    private String gitHttpUrl;
    private String namespace;
    private int visibilityLevel;
    private String pathWithNamespace;
    private String defaultBranch;
    private String ciConfigPath;
    private String homepage;
    private String url;
    private String sshUrl;
    private String httpUrl;
}
