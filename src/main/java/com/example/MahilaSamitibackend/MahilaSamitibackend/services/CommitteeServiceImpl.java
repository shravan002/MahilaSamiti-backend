package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.CommitteeDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommitteeServiceImpl implements CommitteeService {

    @Autowired
    private CommitteeDao committeeDao;

    @Autowired
    private UserService userService;

    @Override
    public Committee createCommittee(Committee committee) {
        Committee committeeSaved = committeeDao.save(committee);
        for (User user : committeeSaved.getMemberList()) {
            User userSaved = userService.getUser(user.getId());
            userSaved.setCommittee(committeeSaved);
            userService.updateUser(userSaved);
        }
        return committeeSaved;
    }

    @Override
    public User addNewUserToCommittee(User user, Long committeeId) {
        //todo get() is present check
        Committee fetchedCommittee = committeeDao.findById(committeeId).get();
        user.setCommittee(fetchedCommittee);
        return userService.createUser(user);
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
    public User updateUser(User user, long committeeId) {
        //todo get() is present check
        Committee fetchedCommittee = committeeDao.findById(committeeId).get();
        user.setCommittee(fetchedCommittee);
        return userService.updateUser(user);
    }

    @Override
    public void deleteCommittee(Long id) {
        Committee committee = committeeDao.getOne(id);
        committeeDao.delete(committee);
    }
}
