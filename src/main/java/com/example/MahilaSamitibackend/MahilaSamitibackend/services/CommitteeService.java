package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;

public interface CommitteeService {

    public Committee createCommittee(Committee committee);
    public Committee getCommittee(Long id);

    public void deleteCommittee(Long id);
}
