package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "therapies")
@Getter
@Setter
public class Therapy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @ManyToMany
    @JoinTable(
            name = "patient_therapy_medications",
            joinColumns = @JoinColumn(name = "therapy_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id")
    )
    private List<Medication> medications;

    public boolean isPreoperative() {
        return "preoperative".equalsIgnoreCase(type);
    }

    public boolean isPostoperative() {
        return "postoperative".equalsIgnoreCase(type);
    }

    // TODO: Implement activity log/audit mechanism (e.g., Hibernate Envers, Spring AOP)
}

