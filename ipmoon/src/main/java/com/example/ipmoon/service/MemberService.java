package com.example.ipmoon.service;

import com.example.ipmoon.domain.Member;
import com.example.ipmoon.repository.MemberRepository;
import com.example.ipmoon.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service // Autowired로 연결시키기 위하여
public class MemberService {
    //ctrl + shift + t로 테스트 만들기
    private final MemberRepository memberRepository;

    //@Autowired //MemoryMemberRepository
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {

        //같은 이름의 중복회원 x
        validateDuplicateMember(member); //ctrl + alt + shift + T 로 refactor

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //ctrl + alt + v 로 Optional 바로 생성
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //한 회원 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
