package com.zhonghaiwenda.gitlab.bot.handle;

import com.zhonghaiwenda.gitlab.bot.model.webhook.event.Event;

/**
 * @author gxz
 * 所有的事件处理器都需要继承此接口
 *
 */
public interface EventHandle<E extends Event,H extends RootHandle<E>> {

    /**
     * 解析事件的过程
     * @param event 事件  事件可能是多种
     */
    public void handle(E event);

    /***
     * 表示此事件如何才能被支持
     * @param event 事件内容
     * @return 返回事件的什么结果是可以解析的
     */
    public boolean support(E event);



}
