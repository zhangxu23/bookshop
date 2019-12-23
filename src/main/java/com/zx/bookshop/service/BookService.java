package com.zx.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.bookshop.entity.Book;
import com.zx.bookshop.mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookService extends ServiceImpl<BookMapper, Book>
{
}
