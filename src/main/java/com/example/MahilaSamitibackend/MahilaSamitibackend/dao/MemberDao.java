package com.example.MahilaSamitibackend.MahilaSamitibackend.dao;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Long> {
}
