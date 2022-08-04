package com.example.MahilaSamitibackend.MahilaSamitibackend.controllers;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;
import com.example.MahilaSamitibackend.MahilaSamitibackend.services.CommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/committee"))
public class CommitteeController {

    @Autowired
    CommitteeService committeeService;

    @PostMapping
    public Committee createCommittee(@RequestBody Committee committee) {
        return committeeService.createCommittee(committee);
    }

    @PostMapping("/{committeeId}/member")
    public Member addMemberToCommittee(@RequestBody Member member, @PathVariable String committeeId) {
        return committeeService.addNewMemberToCommittee(member, Long.parseLong(committeeId));
    }

    @GetMapping("/{committeeId}")
    public Committee getCommittee(@PathVariable String committeeId) {
        return committeeService.getCommittee(Long.parseLong(committeeId));
    }

    @PutMapping
    public Committee updateCommitteInfo(@RequestBody Committee committee) {
        return committeeService.updateCommittee(committee);
    }

    @PutMapping("/{committeeId}/member")
    public Member updateMemberInfo(@RequestBody Member member, @PathVariable String committeeId) {
        return committeeService.updateMember(member, Long.parseLong(committeeId));
    }

    @DeleteMapping("/{committeeId}")
    public ResponseEntity<HttpStatus> deleteCommittee(@PathVariable String committeeId) {
        try {
            committeeService.deleteCommittee(Long.parseLong(committeeId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
