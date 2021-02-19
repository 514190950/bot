package com.zhonghaiwenda.gitlab.bot.handle;

import com.zhonghaiwenda.gitlab.bot.model.webhook.event.Event;

/**
 * @author gxz
 * 核心处理器
 * 实例直接处理分发器分发过来的事件，负责调用子类处理器 也可以单独处理
 */
public interface RootHandle<E extends Event> {


    /**
     * 核心处理器支持什么样的行为  建议直接根据action做行为驱动
     * 举个例子： Issue的action : open close
     * @param event 支持的核心事件
     * @return 是否支持
     */
    public boolean supportAction(E event);


    /**
     * 接受事件之后  处理相应内容
     * 此参数事件一定是符合supportAction的事件
     * @param event 符合{{@link #supportAction(Event)}} 的事件
     */
    public void accept(E event);

}
