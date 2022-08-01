package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;

import java.util.Optional;

public interface CommitteeService {

    public Committee createCommittee(Committee committee);
    public Optional<Committee> getCommittee(Long id);

    public void deleteCommittee(Long id);
}
