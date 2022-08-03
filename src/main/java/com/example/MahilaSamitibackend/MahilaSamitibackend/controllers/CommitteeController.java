package com.example.MahilaSamitibackend.MahilaSamitibackend.controllers;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;
import com.example.MahilaSamitibackend.MahilaSamitibackend.services.CommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//todo generalize controllers path
@RestController
public class CommitteeController {

    @Autowired
    CommitteeService committeeService;

    @PostMapping("/committee")
    public Committee createCommittee(@RequestBody Committee committee){
        return committeeService.createCommittee(committee);
    }

    @PostMapping("/committee/{committeeId}/user")
    public Committee addUserToCommittee(@RequestBody User user, @PathVariable String committeeId){
        return committeeService.addNewUserToCommittee(user, Long.parseLong(committeeId));
    }

    @GetMapping("/committee/{committeeId}")
    public Committee getCommittee(@PathVariable String committeeId){
        return committeeService.getCommittee(Long.parseLong(committeeId));
    }

    @DeleteMapping("/committee/{committeeId}")
    public ResponseEntity<HttpStatus> deleteCommittee(@PathVariable String committeeId){
        try{
            committeeService.deleteCommittee(Long.parseLong(committeeId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
