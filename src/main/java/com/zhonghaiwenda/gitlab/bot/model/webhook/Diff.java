package com.zhonghaiwenda.gitlab.bot.model.webhook;

public class Diff {
    private String diff;
    private String newPath;
    private String oldPath;
    private String aMode;
    private String bMode;
    private boolean newFile;
    private boolean renamedFile;
    private boolean deletedFile;
}