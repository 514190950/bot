package com.zhonghaiwenda.gitlab.bot.util;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 51419
 */
public class EventUtils {
    private static Pattern ISSUE_PATTERN = Pattern.compile("\\s?#[0-9]+\\s?");

    public static void main(String[] args) {
        System.out.println(ISSUE_PATTERN.matcher("#aa").find());
    }
    /**
     * 从mergeRequest的描述中切割出引用的所有Issue的id
     *
     * @return 返回所有的issueId
     */
    public static Set<Integer> subIssueIdsByMRDesc(String description) {
        Set<Integer> ids = new HashSet<>();
        if (StringUtils.hasText(description)) {
            Matcher matcher = ISSUE_PATTERN.matcher(description);
            while (matcher.find()) {
                String idStr = subIssueId(matcher.group());
                ids.add(Integer.parseInt(idStr));
            }
        }
        return ids;
    }

    /**
     * 传入两个merge的desc 可以把mergerequest中引用的issue变为解决内容
     *
     * @param preDesc     之前的desc
     * @param currentDesc 现在的desc
     */
    public static void resolveIssue(String preDesc, String currentDesc,int projectId,int mergeRequestId) {
        Set<Integer> preIds = subIssueIdsByMRDesc(preDesc);
        Set<Integer> currentIds = subIssueIdsByMRDesc(currentDesc);
        Set<Integer> currentIdsTemp = new HashSet<>(currentIds);
        currentIds.removeAll(preIds);
        waitTestIssue(currentIds,projectId,mergeRequestId);
        preIds.removeAll(currentIdsTemp);
        waitResolveIssue(preIds,projectId);
    }


    /**
     * 已经解决 等待测试
     *
     * @param issueIds  需要修改的issueIds
     * @param projectId projectId
     */
    public static void waitTestIssue(Collection<Integer> issueIds, int projectId,int mergeRequestId) {
        for (Integer issueId : issueIds) {
            new IssueProcessExecute(projectId, issueId)
                    .removeTags(Collections.singletonList(Constant.WAIT_RESOLVE))
                    .execute();
            new IssueProcessExecute(projectId, issueId)
                    .addTags(Collections.singletonList(Constant.WAIT_TEST))
                    .execute();
            CommentProcessExecute.commentIssue(projectId, issueId, "在这个MR中已经解决此问题 !"+mergeRequestId+" ,现在等待测试");
        }
    }

    /**
     * 重新进入等待解决的问题 一般在修改mr内容的时候使用
     *
     * @param issueIds  需要修改的issueIds
     * @param projectId projectId
     */
    public static void waitResolveIssue(Collection<Integer> issueIds, int projectId) {
        for (Integer issueId : issueIds) {
            new IssueProcessExecute(projectId, issueId)
                    .removeTags(Collections.singletonList(Constant.WAIT_TEST))
                    .execute();
            new IssueProcessExecute(projectId, issueId)
                    .addTags(Collections.singletonList(Constant.WAIT_RESOLVE))
                    .execute();
            CommentProcessExecute.commentIssue(projectId, issueId, "这个问题已经分配完成 等待解决中");
        }
    }


    private static String subIssueId(String issueString) {
        int lastSpace = issueString.lastIndexOf(" ");
        if(lastSpace!=-1 && lastSpace!=0){
            issueString = issueString.substring(0,lastSpace);
        }
        return issueString.replaceAll("[#\\s]","");
    }


}
