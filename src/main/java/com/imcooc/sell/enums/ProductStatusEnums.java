package com.imcooc.sell.enums;


import lombok.Getter;

/**
 * 商品状态
 */
@Getter
public enum ProductStatusEnums {
    UP(0,"在线"),
    DOWM(1,"下架");

    private Integer  code;
    private String  message;

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
