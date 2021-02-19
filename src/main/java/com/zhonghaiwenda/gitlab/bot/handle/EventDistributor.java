package com.zhonghaiwenda.gitlab.bot.handle;


import com.zhonghaiwenda.gitlab.bot.model.Result;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gxz
 * @date 2021/2/9 16:23
 * 事件的分发器
 */
@Component
public class EventDistributor {

    private Map<String, List<RootDispatch>> handleCache = new HashMap<>();

    private final List<RootDispatch> eventHandles;

    @Autowired
    public EventDistributor(List<RootDispatch> eventHandles) {
        this.eventHandles = eventHandles;
    }

    @PostConstruct
    public void init() {
        for (RootDispatch eventHandle : eventHandles) {
            String dispatchKey = eventHandle.supportEvent().getName();
            handleCache.computeIfAbsent(dispatchKey, (k) -> new ArrayList<>()).add(eventHandle);
        }
    }

    public Result dispatch(Event event) {
        if (event == null) {
            return Result.unSupport();
        }
        List<RootDispatch> rootDispatches = handleCache.get(event.getClass().getName());
        if (rootDispatches == null) {
            return Result.unSupport();
        }
        rootDispatches.forEach(dispatch -> dispatch.dispatch(event));
        return Result.ok();
    }


}
