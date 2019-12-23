package com.zx.bookshop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.bookshop.entity.User;
import com.zx.bookshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;
    public String checkUser(String name){
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>().eq("username",name);
        User user=userMapper.selectOne(queryWrapper);
        if(user==null)
            return "no";
        else
            return "yes";

    }

    public String checkLogin(User u, HttpSession session) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>().eq("username",u.getUsername());
        User user=userMapper.selectOne(queryWrapper);
        if(user==null)
            return "username";
        else
            if(u.getPassword().equals(user.getPassword())) {
                session.setAttribute("user", user);
                return "yes";
            }
            else
                return "password";

    }
}
