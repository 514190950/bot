package com.zhonghaiwenda.gitlab.bot.handle.systemhandle;

import com.zhonghaiwenda.gitlab.bot.handle.EventHandle;
import com.zhonghaiwenda.gitlab.bot.handle.root.handle.IssueUpdateHandle;
import com.zhonghaiwenda.gitlab.bot.model.webhook.ChangeContainer;
import com.zhonghaiwenda.gitlab.bot.model.webhook.EventLabel;
import com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute;
import com.zhonghaiwenda.gitlab.bot.model.webhook.event.IssueEvent;
import com.zhonghaiwenda.gitlab.bot.util.Constant;
import com.zhonghaiwenda.gitlab.bot.util.IssueProcessExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author gxz
 * 当Issue被打上了测试通过时  自动关闭
 */
@Component
public class IssueUpdateTestSuccessHandle implements EventHandle<IssueEvent, IssueUpdateHandle> {


    @Override
    public void handle(IssueEvent event) {
        IssueAttribute objectAttributes = event.getObjectAttributes();
        new IssueProcessExecute(objectAttributes.getProjectId(), objectAttributes.getIid())
                .removeTags(Collections.singletonList(Constant.WAIT_TEST))
                .addTags(Collections.singletonList(Constant.FINISH))
                .execute();
    }

    @Override
    public boolean support(IssueEvent event) {
        ChangeContainer<List<EventLabel>> labels = event.getChanges().getLabels();
        return labels != null && containTag(labels.getCurrent());
    }

    private boolean containTag(List<EventLabel> current) {
        for (EventLabel eventLabel : current) {
            if (Constant.FINISH.equals(eventLabel.getDescription())) {
                return true;
            }
        }
        return false;
    }
}
