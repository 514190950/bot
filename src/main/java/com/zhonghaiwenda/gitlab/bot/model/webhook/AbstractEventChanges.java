package com.zhonghaiwenda.gitlab.bot.model.webhook;

import com.zhonghaiwenda.gitlab.bot.model.user.Assignee;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gxz
 */
@Data
public abstract class AbstractEventChanges {

    private ChangeContainer<Integer> authorId;
    private ChangeContainer<String> createdAt;
    private ChangeContainer<String> updatedAt;
    private ChangeContainer<Integer> updatedById;
    private ChangeContainer<String> title;
    private ChangeContainer<String> description;
    private ChangeContainer<String> state;
    private ChangeContainer<Integer> milestoneId;
    private ChangeContainer<List<EventLabel>> labels;
    private ChangeContainer<List<Assignee>> assignees;
    private ChangeContainer<Integer> totalTimeSpent;
    private Map<String, ChangeContainer<Object>> otherProperties = new LinkedHashMap<>();

}