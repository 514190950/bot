package com.zhonghaiwenda.gitlab.bot.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;

import static com.zhonghaiwenda.gitlab.bot.util.Constant.TOKEN;

public class RequestFactory {


    public static HttpUriRequest put(String uri, Map<String,Object> data){
         return build( RequestBuilder::put,uri,data);
    }

    public static HttpUriRequest get(String uri, Map<String,Object> data){
        return build( RequestBuilder::get,uri,data);
    }

    public static HttpUriRequest post(String uri, Map<String,Object> data){
        return build( RequestBuilder::post,uri,data);
    }

    public static HttpUriRequest delete(String uri, Map<String,Object> data){
        return build( RequestBuilder::delete,uri,data);
    }

    private static HttpUriRequest build(Function<String,RequestBuilder> function,String url,Map<String,Object> data){
        RequestBuilder requestBuilder = function.apply(url).setHeader("PRIVATE-TOKEN", TOKEN)
                .setHeader("Accept", "application/json")
                .setHeader("Content-type", "application/json");
        if(data!=null && !data.isEmpty()){
            requestBuilder.setEntity(new StringEntity(JSONObject.toJSONString(data), StandardCharsets.UTF_8));
        }
        return requestBuilder.build();
    }


}
