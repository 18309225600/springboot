package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    @Cacheable(value="user-key")
    public User index(Integer init){
        User user = new User(1L,"张三","18309225600@163.com","男");
        return  user;
    }


    /**
     * 登录
     */
    @RequestMapping("/login/{uid}")
    public Object login(HttpSession session,@PathVariable("uid") Long uid){
        Object attribute = (Object)session.getAttribute(uid.toString());
        if (attribute==null){
            User user = new User(1L,"张三","18309225600@163.com","男");
            session.setAttribute(uid.toString(), user);
            System.out.println("==============》session不存在");
        }else{
            System.out.println("==============》session存在"+attribute);
        }

        return attribute;
    }
}
