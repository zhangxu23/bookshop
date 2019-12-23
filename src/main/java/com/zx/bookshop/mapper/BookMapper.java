package com.zx.bookshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.bookshop.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper extends BaseMapper<Book> {
    @Select({
            "<script>\n  select * from bs-book where id in <foreach item='id' collection='ids' open='(' separtor=',' close=')' </foreach> </script>"
    })
    List<Book> findByIddds(@Param("ids") List<String> ids);
}
