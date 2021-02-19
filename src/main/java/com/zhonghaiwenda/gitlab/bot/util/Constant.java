package com.zhonghaiwenda.gitlab.bot.util;

import java.util.ArrayList;
import java.util.List;

public class Constant {

    public static String GITLAB_PATH = "http://172.16.1.220";

    public static String API_PREFIX = GITLAB_PATH + "/api/v4";

    public final static String TOKEN;

    public final static String WAIT_ASSIGNEE = "等待分配";

    public final static String WAIT_RESOLVE = "等待解决";

    public final static String WAIT_TEST = "等待测试";

    public final static String FAIL_TEST = "测试未通过";

    public final static String FINISH = "测试通过";


    static {
        TOKEN = System.getenv("GitLab_Bot_Token");

    }

    public static List<String> excludeTag(String tag) {
        List<String> all = new ArrayList<>();
        all.add(WAIT_ASSIGNEE);
        all.add(WAIT_RESOLVE);
        all.add(WAIT_TEST);
        all.add(FAIL_TEST);
        all.add(FINISH);
        all.remove(tag);
        return all;
    }


}
