package com.example.MahilaSamitibackend.MahilaSamitibackend.dao;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitteeDao extends JpaRepository<Committee, Long> {
}
