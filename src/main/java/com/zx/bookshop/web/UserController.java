package com.zx.bookshop.web;

import com.zx.bookshop.entity.User;
import com.zx.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/checkUser")
    @ResponseBody
    public String checkUser(String userName){
        return userService.checkUser(userName);
    }
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user){
        userService.save(user);
        return "yes";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpSession session){

        return userService.checkLogin(user,session);
    }
    @RequestMapping("/logout")
    public String logout( HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
