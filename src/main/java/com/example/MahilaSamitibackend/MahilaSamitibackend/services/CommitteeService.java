package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;

public interface CommitteeService {

    Committee createCommittee(Committee committee);

    Committee getCommittee(Long id);

    void deleteCommittee(Long id);

    Committee addNewUserToCommittee(User user, Long committeeId);
}
