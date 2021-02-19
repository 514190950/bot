package com.zhonghaiwenda.gitlab.bot.handle.root.handle;

import com.zhonghaiwenda.gitlab.bot.handle.EventHandle;
import com.zhonghaiwenda.gitlab.bot.handle.RootHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.IssueEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute.IssueAction.update;

/**
 * @author gxz
 */
@Component
public class IssueUpdateHandle implements RootHandle<IssueEvent> {

    @Autowired
    private List<EventHandle<IssueEvent, IssueUpdateHandle>> eventHandleList;



    @Override
    public boolean supportAction(IssueEvent event) {
        return event.getObjectAttributes().getAction() == update;
    }

    @Override
    public void accept(IssueEvent event) {
        eventHandleList.stream().filter(handle->handle.support(event)).forEach(handle->handle.handle(event));
    }
}
