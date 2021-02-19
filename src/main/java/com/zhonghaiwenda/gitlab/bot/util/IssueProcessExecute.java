package com.zhonghaiwenda.gitlab.bot.util;


import com.zhonghaiwenda.gitlab.bot.model.webhook.attribute.IssueAttribute;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zhonghaiwenda.gitlab.bot.util.Constant.API_PREFIX;

/**
 * @author gxz
 * 这是一个系统默认的issue的处理器  包装了各种GitLab的api
 */

public class IssueProcessExecute {

    private Map<String, Object> data = new HashMap<>();
    private final long projectId;
    private final long issuesIid;

    public IssueProcessExecute(long projectId, long issuesIid) {
        this.projectId = projectId;
        this.issuesIid = issuesIid;
    }

    public IssueProcessExecute(IssueAttribute issueAttribute) {
        this.projectId = issueAttribute.getProjectId();
        this.issuesIid = issueAttribute.getIid();
    }

    /***
     * 增加标签
     * @param tags 标签内容
     */
    public IssueProcessExecute addTags(List<String> tags) {
        data.put("add_labels", String.join(",", tags));
        return this;
    }

    /***
     * 移除标签
     * @param tags 标签内容
     */
    public IssueProcessExecute removeTags(List<String> tags) {
        data.put("remove_labels", String.join(",", tags));
        return this;
    }

    /***
     * 覆盖标签
     * @param tags 标签内容
     */
    public IssueProcessExecute coverTags(List<String> tags) {
        data.put("labels", String.join(",", tags));
        return this;
    }

    public void execute() {
        String uri = API_PREFIX + "/projects/" + projectId + "/issues/" + issuesIid;
        HttpUriRequest request = RequestFactory.put(uri, this.data);
        try (CloseableHttpClient httpclient = HttpClients.createDefault();
             CloseableHttpResponse execute = httpclient.execute(request)) {
            System.out.println(execute);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
