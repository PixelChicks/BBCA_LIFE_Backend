package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "steppers")
public class Stepper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "breast_operation_id")
    private Long breastOperationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Stepper() {
    }

    public Long getId() {
        return id;
    }

    public Long getBreastOperationId() {
        return breastOperationId;
    }

    public void setBreastOperationId(Long breastOperationId) {
        this.breastOperationId = breastOperationId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

