package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medication_intakes")
public class MedicationIntake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_therapy_medication_id")
    private PatientTherapyMedication patientTherapyMedication;

    public MedicationIntake() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientTherapyMedication getPatientTherapyMedication() {
        return patientTherapyMedication;
    }

    public void setPatientTherapyMedication(PatientTherapyMedication patientTherapyMedication) {
        this.patientTherapyMedication = patientTherapyMedication;
    }
}

