package com.zqq.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    up(0,"上架"),
    down(1,"下架");
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
