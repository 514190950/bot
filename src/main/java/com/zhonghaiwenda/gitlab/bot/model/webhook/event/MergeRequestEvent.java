package com.zhonghaiwenda.gitlab.bot.model.webhook.event;

import com.zhonghaiwenda.gitlab.bot.model.user.Assignee;
import com.zhonghaiwenda.gitlab.bot.model.user.User;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventLabel;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventProject;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventRepository;
import com.zhonghaiwenda.gitlab.bot.model.webhook.MergeRequestChanges;
import lombok.Data;

import java.time.Duration;
import java.util.List;
import java.util.Map;


/**
 * @author gxz
 */
@Data
public class MergeRequestEvent extends AbstractWebHookEvent {


    private User user;
    private EventProject project;
    private EventRepository repository;
    private ObjectAttributes objectAttributes;
    private List<EventLabel> labels;
    private MergeRequestChanges changes;
    private List<Assignee> assignees;


    @Data
    public static class ObjectAttributes{
        private Integer assigneeId;
        private Integer authorId;
        private String branchName;
        private String createdAt;
        private String description;
        private Integer id;
        private Integer iid;
        private String mergeCommitSha;
        private String mergeStatus;
        private Integer milestoneId;
        private Integer position;
        private String lockedAt;
        private Integer projectId;
        private String sourceBranch;
        private Integer sourceProjectId;
        private String stCommits;
        private String stDiffs;
        private String state;
        private String targetBranch;
        private Integer targetProjectId;
        private String title;
        private String updatedAt;

        private EventProject source;
        private EventProject target;
        private EventCommit lastCommit;
        private Boolean workInProgress;
        private String url;
        private MergeRequest action;
        private Assignee assignee;

        private Integer updatedById;
        private String mergeError;
        private Map<String, String> mergeParams;
        private Boolean mergeWhenPipelineSucceeds;
        private Integer mergeUserId;
        private String deletedAt;
        private String inProgressMergeCommitSha;
        private Integer lockVersion;

        private String lastEditedAt;
        private Integer lastEditedById;
        private Integer headPipelineId;
        private Boolean refFetched;
        private Integer mergeIid;
        private Integer totalTimeSpent;
        private Duration humanTotalTimeSpent;
        private Integer timeEstimate;
        private Duration humanTimeEstimate;
        private List<Integer> assigneeIds;
    }

    public enum MergeRequest{
        open,update,reopen,close,merge;
    }
}
