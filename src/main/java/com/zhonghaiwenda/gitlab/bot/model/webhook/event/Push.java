package com.zhonghaiwenda.gitlab.bot.model.webhook.event;

import lombok.Data;

import java.util.List;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Data
public class Push implements Event {
    private String objectKind;
    private String before;
    private String after;
    private String ref;
    private String checkoutSha;
    private int userId;
    private String userName;
    private String userUsername;
    private String userEmail;
    private String userAvatar;
    private int projectId;
    private ProjectBean project;
    private RepositoryBean repository;
    private int totalCommitsCount;
    private List<CommitsBean> commits;

    @Data
    public static class ProjectBean {

        private long id;
        private String name;
        private String description;
        private String webUrl;
        private Object avatarUrl;
        private String gitSshUrl;
        private String gitHttpUrl;
        private String namespace;
        private int visibilityLevel;
        private String pathWithNamespace;
        private String defaultBranch;
        private String homepage;
        private String url;
        private String sshUrl;
        private String httpUrl;

    }

    @Data
    public static class RepositoryBean {
        private String name;
        private String url;
        private String description;
        private String homepage;
        private String gitHttpUrl;
        private String gitSshUrl;
        private int visibilityLevel;
    }

    @Data
    public static class CommitsBean {

        private String id;
        private String message;
        private String title;
        private String timestamp;
        private String url;
        private AuthorBean author;
        private List<String> added;
        private List<String> modified;
        private List<?> removed;

        @Data
        public static class AuthorBean {

            private String name;
            private String email;

        }
    }
}
