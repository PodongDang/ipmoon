package com.example.ipmoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    //Controller annotation 필수
    //Model을 통해 MVC 패턴
    @GetMapping("Hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

}
