package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient_therapy_medications")
public class PatientTherapyMedication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate firstDoseDate;

    private String customMedication;

    private String customMedicationDose;

    private Long checkedBy;

    private LocalDate checkedOn;

    // Relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;

    @OneToMany(mappedBy = "patientTherapyMedication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alarm> alarms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id", insertable = false, updatable = false)
    private Medication medication;

    // filtered relationships (category = 'home' or 'hospital') are handled via repository queries

    @OneToMany(mappedBy = "patientTherapyMedication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicationIntake> medicationIntakes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapy_id", insertable = false, updatable = false)
    private CancerTherapy cancerTherapy;

    // Constructors, getters, and setters...

    // Example constructor
    public PatientTherapyMedication() {
    }

    // Add other getters and setters...

    // Methods to replicate Laravel scopes or query logic could be in repository/service classes

}
