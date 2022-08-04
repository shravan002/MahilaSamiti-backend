package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;

public interface CommitteeService {

    Committee createCommittee(Committee committee);

    User addNewUserToCommittee(User user, Long committeeId);

    Committee getCommittee(Long id);

    Committee updateCommittee(Committee committee);

    User updateUser(User user, long parseLong);

    void deleteCommittee(Long id);
}
