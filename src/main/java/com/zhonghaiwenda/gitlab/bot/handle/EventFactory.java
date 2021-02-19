package com.zhonghaiwenda.gitlab.bot.handle;


import com.alibaba.fastjson.JSONObject;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.*;
import org.springframework.stereotype.Component;


/**
 * @author gxz
 * @date 2021/2/9 18:22
 */
@Component
public class EventFactory {


    public Event eventTrigger(String head, String body) {
        return EventType.eventSelect(head, body);
    }

    /**
     * 目前支持的相关事件，可持续更新
     * 详情可关注https://docs.gitlab.com/ee/user/project/integrations/webhooks.html#job-events
     *
     * @author gongxuanzhang@foxmail.com
     */
    public enum EventType {


        ISSUE("Issue Hook", IssueEvent.class),
        Node("Note Hook", NoteEvent.class),
        MergeRequest("Merge Request Hook",MergeRequestEvent.class);

        private final String headMapping;

        private final Class<? extends Event> eventClass;


        EventType(String headMapping, Class<? extends AbstractWebHookEvent> eventClass) {
            this.headMapping = headMapping;
            this.eventClass = eventClass;
        }

        public static Event eventSelect(String head, String body) {
            for (EventType value : values()) {
                if (value.headMapping.equals(head)) {
                    return JSONObject.parseObject(body, value.eventClass);
                }
            }
            return null;
        }

    }


}
