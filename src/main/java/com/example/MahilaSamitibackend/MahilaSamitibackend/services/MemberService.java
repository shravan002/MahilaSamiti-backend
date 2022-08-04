package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMembers();

    Member getMember(Long memberId);

    Member createMember(Member member);

    Member updateMember(Member member);

    void deleteMember(Long memberId);
}

