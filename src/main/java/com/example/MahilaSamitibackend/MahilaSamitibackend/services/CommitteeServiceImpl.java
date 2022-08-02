package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.CommitteeDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommitteeServiceImpl implements CommitteeService{

    @Autowired
    private CommitteeDao committeeDao;

    @Autowired
    private UserService userService;
    @Override
    public Committee createCommittee(Committee committee) {
        Committee committeeSaved = committeeDao.save(committee);
        for(User user: committeeSaved.getMemberList()){
            User userSaved = userService.getUser(user.getMobileNumber());
            userSaved.setCommitteeMember(committeeSaved);
            userService.updateUser(userSaved);
        }
        return committeeSaved;
    }

    @Override
    public Committee getCommittee(Long id) {
        Optional<Committee> committee = committeeDao.findById(id);
        if(committee.isPresent())
            return committee.get();
        else
            throw new RuntimeException();
    }

    @Override
    public void deleteCommittee(Long id) {
        Committee committee = committeeDao.getOne(id);
        committeeDao.delete(committee);
    }
}
