package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.CommitteeDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommitteeServiceImpl implements CommitteeService {

    @Autowired
    private CommitteeDao committeeDao;

    @Autowired
    private MemberService memberService;

    @Override
    public Committee createCommittee(Committee committee) {
        Committee committeeSaved = committeeDao.save(committee);
        for (Member member : committeeSaved.getMemberList()) {
            Member memberSaved = memberService.getMember(member.getId());
            memberSaved.setCommittee(committeeSaved);
            memberService.updateMember(memberSaved);
        }
        return committeeSaved;
    }

    @Override
    public Member addNewMemberToCommittee(Member member, Long committeeId) {
        //todo get() is present check
        Committee fetchedCommittee = committeeDao.findById(committeeId).get();
        member.setCommittee(fetchedCommittee);
        return memberService.createMember(member);
    }

    @Override
    public Committee getCommittee(Long id) {
        Optional<Committee> committee = committeeDao.findById(id);
        if (committee.isPresent()) return committee.get();
        else throw new RuntimeException();
    }

    @Override
    public Committee updateCommittee(Committee committee) {
        return committeeDao.save(committee);
    }

    @Override
    public Member updateMember(Member member, long committeeId) {
        //todo get() is present check
        Committee fetchedCommittee = committeeDao.findById(committeeId).get();
        member.setCommittee(fetchedCommittee);
        return memberService.updateMember(member);
    }

    @Override
    public void deleteCommittee(Long id) {
        Committee committee = committeeDao.getOne(id);
        committeeDao.delete(committee);
    }
}
