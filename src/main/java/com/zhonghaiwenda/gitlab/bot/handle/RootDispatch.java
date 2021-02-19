package com.zhonghaiwenda.gitlab.bot.handle;

import com.zhonghaiwenda.gitlab.bot.model.webhook.event.Event;

/**
 * @author gxz
 * 分发器，分发器接受一个核心事件  ex:{@link com.zhonghaiwenda.gitlab.bot.model.webhook.event.AbstractWebHookEvent}
 * 接收到一个分发器之后负责交给核心处理器  {@link RootHandle};
 * 继承此接口说明是一个可以直接对发生的事件进行处理的实例
 * 可以将把对应的事件分发出去
 *
 */
public interface RootDispatch<E extends Event>{

    /**
     * 分发
     * @param event 获得的核心事件
     */
 public void dispatch(E event);


    /***
     * 返回一个支持的事件类型Class
     * @return 支持的事件类型
     */
 public Class<E> supportEvent();

}
