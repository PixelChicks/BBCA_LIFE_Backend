package com.bbcalife.bbcalife.model;

import jakarta.persistence.*;
import lombok.*;
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

    // Many-to-many with Patient, with extra pivot field 'patient_data'
    @ManyToMany
    @JoinTable(
            name = "patient_additional_medical_conditions",
            joinColumns = @JoinColumn(name = "condition_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients;

    // Note: To access the pivot field 'patient_data', you need a separate entity for the join table.

}
