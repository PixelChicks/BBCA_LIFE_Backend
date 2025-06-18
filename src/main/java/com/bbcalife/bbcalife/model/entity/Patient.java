package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE patients SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assistant_id")
    private Assistant assistant;

    private LocalDate birthDate;
    private String cancerStage;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    private String gender;
    private String menstrualCycleStatus;
    private LocalDate menstrualCycleStatusChangedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @OneToOne(mappedBy = "patient")
    private Stepper stepper;

    @OneToMany(mappedBy = "patient")
    private List<Cancer> cancers;

    @ManyToMany
    @JoinTable(
            name = "doctors_patients",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;

    @ManyToMany
    @JoinTable(
            name = "patient_additional_medical_conditions",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "condition_id")
    )
    private List<AdditionalMedicalCondition> additionalMedicalConditions;

    @OneToMany(mappedBy = "patient")
    private List<PatientFile> files;

    @OneToOne(mappedBy = "patient")
    private Exercise exercises;

    @ManyToMany
    @JoinTable(
            name = "patient_symptoms",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private List<Symptom> symptoms;

    @OneToMany(mappedBy = "patient")
    private List<LifeQuality> lifeQualityQuestionnairs;

    @OneToMany(mappedBy = "patient")
    private List<MentalHealth> mentalHealthQuestionnairs;

    @ManyToMany
    @JoinTable(
            name = "patient_therapy_medications",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id")
    )
    private List<Medication> medications;

    @OneToMany(mappedBy = "patient")
    private List<PatientTherapyMedication> patientTherapyMedications;

    @OneToMany(mappedBy = "patient")
    private List<Task> tasks;

    @OneToMany(mappedBy = "patient")
    private List<Event> events;
}

