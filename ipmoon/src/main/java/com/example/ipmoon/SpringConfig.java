package com.example.ipmoon;

import com.example.ipmoon.repository.MemberRepository;
import com.example.ipmoon.repository.MemoryMemberRepository;
import com.example.ipmoon.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
