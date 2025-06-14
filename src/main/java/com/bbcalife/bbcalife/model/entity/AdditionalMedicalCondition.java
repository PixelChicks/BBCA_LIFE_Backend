package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "additional_medical_conditions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdditionalMedicalCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private String name;

    @Column(name = "custom_data", columnDefinition = "TEXT")
    private String customData;

    @ManyToMany
    @JoinTable(
            name = "patient_additional_medical_conditions",
            joinColumns = @JoinColumn(name = "condition_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients;
}