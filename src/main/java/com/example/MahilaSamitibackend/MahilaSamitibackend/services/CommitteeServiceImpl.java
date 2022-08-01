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
        return committeeDao.save(committee);
    }
//    @Override
//    public Committee createCommittee(Committee committee) {
//        Committee committeeSaved = committeeDao.save(committee);
//        for(User user: committeeSaved.getMemberList()){
//            User userSaved = userService.getUser(user.getMobileNumber());
//            userService.updateUser(userSaved.setCommitteeMember(committeeSaved));
//        }
//    }

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
