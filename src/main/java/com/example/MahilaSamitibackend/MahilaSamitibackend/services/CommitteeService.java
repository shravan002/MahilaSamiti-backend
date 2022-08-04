package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;

public interface CommitteeService {

    Committee createCommittee(Committee committee);

    Member addNewMemberToCommittee(Member member, Long committeeId);

    Committee getCommittee(Long id);

    Committee updateCommittee(Committee committee);

    Member updateMember(Member member, long parseLong);

    void deleteCommittee(Long id);
}
