package com.zhonghaiwenda.gitlab.bot.model.webhook;


import lombok.Data;

@Data
public class ChangeContainer<T> {
    
    private T previous;
    private T current;

}