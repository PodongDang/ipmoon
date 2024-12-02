package com.example.ipmoon.controller;

import com.example.ipmoon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링이 컨테이너를 가져와서 연결시켜줌(Dependency Injection)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
