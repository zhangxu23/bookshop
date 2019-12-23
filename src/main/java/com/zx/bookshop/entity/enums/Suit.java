package com.zx.bookshop.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

import java.io.Serializable;

@Getter
public enum  Suit  implements IEnum {
    YES(1,"是"),
    NO(2,"否");
    Suit(int code, String desc){
        this.code=code;
        this.desc = desc;
    }
    private final int code;
    private final String desc;

    @Override
    public Serializable getValue() {
        return this.code;
    }
}
