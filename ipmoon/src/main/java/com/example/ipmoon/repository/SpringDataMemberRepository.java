package com.example.ipmoon.repository;

import com.example.ipmoon.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL
    @Override
    Optional<Member> findByName(String name);
}
