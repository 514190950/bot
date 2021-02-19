package com.zhonghaiwenda.gitlab.bot.controller;

import com.zhonghaiwenda.gitlab.bot.handle.EventDistributor;
import com.zhonghaiwenda.gitlab.bot.handle.EventFactory;
import com.zhonghaiwenda.gitlab.bot.model.Result;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.AbstractWebHookEvent;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/


@RestController
public class WebHookController {

    public static final String GITLAB_HEAD = "X-Gitlab-Event";

    private final EventDistributor eventDistributor;

    private final EventFactory eventFactory;

    @Autowired
    public WebHookController(EventDistributor eventDistributor, EventFactory eventFactory) {
        this.eventDistributor = eventDistributor;
        this.eventFactory = eventFactory;
    }

    @RequestMapping("/root")
    public Result root(@RequestBody String body, HttpServletRequest httpServletRequest) {
        Event event = eventFactory.eventTrigger(httpServletRequest.getHeader(GITLAB_HEAD), body);
        return eventDistributor.dispatch(event);
    }

}
