package com.zhonghaiwenda.gitlab.bot.model.webhook;


import lombok.Data;


/**
 * @author gongxuanzhang
 */
@Data
public class IssueChanges extends AbstractEventChanges {
    private ChangeContainer<String> dueDate;
    private ChangeContainer<Boolean> confidential;

}
