package com.zhonghaiwenda.gitlab.bot.model;


import lombok.Data;

import java.io.Serializable;

/**
 * @author gxz
 * @date 2021/2/9 18:06
 */
@Data
public class Result implements Serializable {

    private String message;

    private int code;

    public static Result ok(){
        return new Result().setCode(200).setMessage("OK");
    }

    public static Result unSupport(){
        return new Result().setCode(501).setMessage("unSupport");
    }

}
