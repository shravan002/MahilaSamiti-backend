package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.CommitteeDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommitteeServiceImpl implements CommitteeService{

    @Autowired
    private CommitteeDao committeeDao;
    @Override
    public Committee createCommittee(Committee committee) {
        return committeeDao.save(committee);
    }

    @Override
    public Optional<Committee> getCommittee(Long id) {
        return committeeDao.findById(id);
    }

    @Override
    public void deleteCommittee(Long id) {
        Committee committee = committeeDao.getOne(id);
        committeeDao.delete(committee);
    }
}
