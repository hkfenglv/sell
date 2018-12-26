package com.fenglv.sell.constants;

import lombok.Getter;

@Getter
public enum ProductInfoConstants {

    ACTIVE(1,"已上架"),
    INACTIVE(0,"下架");

    private Integer code;
    private String desc;

    ProductInfoConstants(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
