package com.zx.bookshop.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

import java.io.Serializable;

@Getter
public enum Category implements IEnum{
    SELECTED(1,"精选图书"),
    RECOMMEND(2,"推荐图书"),
    BARGAIN(3,"特价图书");
    Category(int code, String desc){
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

