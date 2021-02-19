package com.zhonghaiwenda.gitlab.bot.model.webhook.event;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zhonghaiwenda.gitlab.bot.model.user.Assignee;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventProject;
import lombok.Data;

import java.time.Duration;
import java.util.List;
import java.util.Map;
/**
 * @author gxz
 */
@Data
public class EventMergeRequest {
    
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
    private String action;
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