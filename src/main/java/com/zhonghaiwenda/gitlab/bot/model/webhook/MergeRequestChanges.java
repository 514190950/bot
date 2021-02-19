package com.zhonghaiwenda.gitlab.bot.model.webhook;


import lombok.Data;

/**
 * @author gxz
 */
@Data
public class MergeRequestChanges extends AbstractEventChanges {
    private ChangeContainer<String> mergeStatus;

}