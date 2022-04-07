package com.shubao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestBootController {

    @RequestMapping("/api/question/getString")
    public String getString(String username, String password){
        System.out.println("username: " + username + ", password: " + password);
        return "ok";
    }
}
