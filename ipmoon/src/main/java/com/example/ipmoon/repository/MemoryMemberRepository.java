package com.example.ipmoon.repository;

import com.example.ipmoon.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository // for Autowired
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//Optional로 null 가능하게
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //1개라도 찾기
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //values는 멤버들
    }

    public void clearStore() {
        store.clear();
    }
}
