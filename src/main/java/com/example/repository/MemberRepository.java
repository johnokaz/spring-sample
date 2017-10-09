package com.example.repository;

import com.example.domain.Member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query("SELECT x FROM Member x ORDER BY x.firstname")
    List<Member> findAllOrderByName();

    @Query("SELECT x FROM Member x ORDER BY x.firstname")
    Page<Member> findAllOrderByName(Pageable pageable);
}
