package com.zhonghaiwenda.gitlab.bot.model.webhook.attribute;

import com.zhonghaiwenda.gitlab.bot.model.webhook.EventLabel;
import lombok.Data;
import java.util.List;

/**
 * @author gongxuanzhang
 */
@Data
public class IssueAttribute {
    private long id;
    private String title;
    private int assigneeId;
    private int authorId;
    private int projectId;
    private String createdAt;
    private String updatedAt;
    private int updatedById;
    private String lastEditedAt;
    private int lastEditedById;
    private int relativePosition;
    private String description;
    private int milestoneId;
    private int stateId;
    private boolean confidential;
    private boolean discussionLocked;
    private String dueDate;
    private int movedToId;
    private int duplicatedToId;
    private int timeEstimate;
    private int totalTimeSpent;
    private String humanTotalTimeSpent;
    private String humanTimeEstimate;
    private Object weight;
    private int iid;
    private String url;
    private String state;
    private IssueAction action;
    private List<Integer> assigneeIds;
    private List<EventLabel> labels;

    public enum IssueAction {
        open, reopen, close, update;
    }
}
