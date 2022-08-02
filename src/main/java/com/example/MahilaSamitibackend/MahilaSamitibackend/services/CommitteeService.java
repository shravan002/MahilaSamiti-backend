package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;

public interface CommitteeService {

    public Committee createCommittee(Committee committee);
    public Committee getCommittee(Long id);

    public void deleteCommittee(Long id);

    Committee addNewUserToCommittee(User user, Long committeeId);
}
