package com.zx.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.bookshop.entity.Book;
import com.zx.bookshop.entity.enums.Category;
import com.zx.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @RequestMapping("/")
    public String index(){
        //bookService.list().forEach(System.out::println);
        return "index";
    }
    @RequestMapping("getBookData")
    public String getBookData(Model model ,Integer page,Integer category){
        QueryWrapper<Book> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("category", Category.SELECTED);
        IPage<Book> iPage=bookService.page(new Page<>(page,4), objectQueryWrapper);
        model.addAttribute("bookList",iPage.getRecords());
        model.addAttribute("pre",iPage.getCurrent()-1);
        model.addAttribute("cur",iPage.getCurrent());
        model.addAttribute("next",iPage.getCurrent()+1);
        model.addAttribute("last",iPage.getPages());
        model.addAttribute("category",category);
        return "bookData";
    }
    @RequestMapping("bookList")
    public String bookList(Model model ,Integer page,Integer category){

        return "books_list";
    }

}
