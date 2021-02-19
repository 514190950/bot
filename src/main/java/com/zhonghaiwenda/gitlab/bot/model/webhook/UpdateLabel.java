package com.zhonghaiwenda.gitlab.bot.model.webhook;

import lombok.Data;

import java.util.List;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Data
public class UpdateLabel {

    private List<EventLabel> previous;
    private List<EventLabel> current;


}
