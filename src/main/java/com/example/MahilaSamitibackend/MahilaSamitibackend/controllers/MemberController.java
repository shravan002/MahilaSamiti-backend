package com.example.MahilaSamitibackend.MahilaSamitibackend.controllers;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;
import com.example.MahilaSamitibackend.MahilaSamitibackend.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping
    public List<Member> getCourse() {
        return memberService.getMembers();
    }

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable String memberId) {
        return memberService.getMember(Long.parseLong(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable String memberId) {
        try {
            memberService.deleteMember(Long.parseLong(memberId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
