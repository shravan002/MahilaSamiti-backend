package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="committee")
public class Committee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long CommitteeId;

    private String committeeName;

    @OneToMany(mappedBy = "committee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<User> memberList = new ArrayList<>();

    @Column(length = 500)
    private String description;
}
