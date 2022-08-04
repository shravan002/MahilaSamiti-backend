package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.MemberDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member createMember(Member member) {
        return memberDao.save(member);
    }

    @Override
    public List<Member> getMembers() {
        return memberDao.findAll();
    }

    @Override
    public Member getMember(Long memberId) {
        return memberDao.findById(memberId).get();
    }


    @Override
    public Member updateMember(Member member) {
        return memberDao.save(member);
    }

    @Override
    public void deleteMember(Long memberId) {
        Member member = getMember(memberId);
        memberDao.delete(member);
    }
}

