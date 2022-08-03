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

    //Values expected in terms of month
    private int committeeLife;
    //MPR: Monthly percentage rate
    private int mpr;

    @Enumerated(EnumType.STRING)
    private CollectionFrequency collectionFrequency;

    private Long totalBalance;
    private Long lentAmount;
    private Long interestBalance;

}
