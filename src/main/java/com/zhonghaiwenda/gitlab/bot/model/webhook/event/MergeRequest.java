package com.zhonghaiwenda.gitlab.bot.model.webhook.event;


import com.zhonghaiwenda.gitlab.bot.model.webhook.IssueChanges;
import com.zhonghaiwenda.gitlab.bot.model.webhook.Commit;
import com.zhonghaiwenda.gitlab.bot.model.user.User;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventLabel;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventProject;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventRepository;
import lombok.Data;

import java.util.List;

/**
 * @author gxz
 * @date 2021/2/8 18:43
 */
@Data
public class MergeRequest implements Event {

    private String objectKind;
    private User user;
    private EventProject project;
    private EventRepository repository;
    private ObjectAttributesBean objectAttributes;
    private IssueChanges changes;
    private List<EventLabel> labels;


    @Data
    public static class ObjectAttributesBean {
        private int id;
        private String targetBranch;
        private String sourceBranch;
        private int sourceProjectId;
        private int authorId;
        private int assigneeId;
        private String title;
        private String createdAt;
        private String updatedAt;
        private Object milestoneId;
        private String state;
        private String mergeStatus;
        private int targetProjectId;
        private int iid;
        private String description;
        private Node source;
        private Node target;
        private Commit lastCommit;
        private boolean workInProgress;
        private String url;
        private String action;
        private User assignee;

        @Data
        public static class Node {
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

    }


}
