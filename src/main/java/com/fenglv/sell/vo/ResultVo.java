package com.fenglv.sell.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    /**错误码.*/
    private  Integer code;
    /**错误描述.*/
    private  String msg;
    /**数据.*/
    private T data;
}
