package com.zhonghaiwenda.gitlab.bot.model.webhook.event;


import com.zhonghaiwenda.gitlab.bot.model.user.User;
import com.zhonghaiwenda.gitlab.bot.model.webhook.Diff;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventProject;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventRepository;

import lombok.Data;

/**
 * @author gxz
 */
@Data
public class NoteEvent extends AbstractWebHookEvent {

    private String objectKind;
    private User user;
    private Integer projectId;
    private EventProject project;
    private EventRepository repository;
    private ObjectAttributes objectAttributes;
    private EventCommit commit;
    private EventIssue issue;
    private EventMergeRequest mergeRequest;
    private EventSnippet snippet;


    @Data
    public static class ObjectAttributes {

        private Integer id;
        private String note;
        private NoteableType noteableType;
        private Integer authorId;
        private String createdAt;
        private String updatedAt;
        private Integer projectId;
        private String attachment;
        private String lineCode;
        private String commitId;
        private Integer noteableId;
        private Boolean system;
        private Diff stDiff;
        private String url;

    }
    public enum NoteableType{
        MergeRequest,Issue,Snippet,Commit;
    }
}
