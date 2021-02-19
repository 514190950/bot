package com.zhonghaiwenda.gitlab.bot.model.webhook.event;


import com.zhonghaiwenda.gitlab.bot.model.webhook.EventProject;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventRepository;
import lombok.Data;

import java.util.List;

/**
 * @author gxz
 * @date 2021/2/8 14:56
 */
@Data
public class Tag implements Event {
    private String objectKind;
    private String before;
    private String after;
    private String ref;
    private String checkoutSha;
    private int userId;
    private String userName;
    private String userAvatar;
    private int projectId;
    private EventProject project;
    private EventRepository repository;
    private int totalCommitsCount;
    private List<String> commits;


}
