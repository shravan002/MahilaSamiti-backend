package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mobileNumber;
    private String name;
    private String role;
    //It is marker to identify in the Scheduler that "Is the user eligible for Minimum due calculation
    private boolean minDueEligibility;
    //todo break the entity
    //outstandingAmount: 4000
    private long outstandingAmount;
    //interestDue: 40
    private long minimumDue;
    //interestPaid:160
    private long interestPaid;
    //cyclicAmountPaid: 800 (200 x 4)
    private long cyclicAmountPaid;
    @ManyToOne
    @JsonBackReference
    private Committee committee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Member member = (Member) o;
        return id != null && Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
