package com.lhf.springboot.controller;

import com.lhf.springboot.entitys.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String index(Model model){
        User user = new User();
        user.setUsername("张三");
        model.addAttribute("user",user);
        return "index";
    }
}
