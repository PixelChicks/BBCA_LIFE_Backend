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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;

    @OneToMany(mappedBy = "patientTherapyMedication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alarm> alarms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id", insertable = false, updatable = false)
    private Medication medication;

    @OneToMany(mappedBy = "patientTherapyMedication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicationIntake> medicationIntakes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapy_id", insertable = false, updatable = false)
    private CancerTherapy cancerTherapy;

    public PatientTherapyMedication() {
    }
}