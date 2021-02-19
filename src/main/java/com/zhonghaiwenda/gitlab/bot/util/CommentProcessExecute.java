package com.zhonghaiwenda.gitlab.bot.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.zhonghaiwenda.gitlab.bot.util.Constant.API_PREFIX;
import static com.zhonghaiwenda.gitlab.bot.util.Constant.TOKEN;

/**
 * @author gxz
 * @date 2021/2/13 20:16
 */
public class CommentProcessExecute {

    public static void commentIssue(int projectId, int issueIid, String body) {
        Map<String, Object> data = new HashMap<>();
        data.put("body", body);
        HttpUriRequest request = RequestBuilder.post(API_PREFIX + "/projects/" + projectId + "/issues/" + issueIid + "/notes")
                .setHeader("PRIVATE-TOKEN", TOKEN)
                .setHeader("Accept", "application/json")
                .setHeader("Content-type", "application/json")
                .setEntity(new StringEntity(JSONObject.toJSONString(data), StandardCharsets.UTF_8)).build();
        try (CloseableHttpClient httpclient = HttpClients.createDefault();
             CloseableHttpResponse execute = httpclient.execute(request)) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
