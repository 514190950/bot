package com.zhonghaiwenda.gitlab.bot.model.webhook.event;

import lombok.Data;

/**
 * @author gxz
 */
@Data
public abstract class AbstractWebHookEvent implements Event{

    private String requestUrl;
    private String requestQueryString;
    private String secretToken;

}
