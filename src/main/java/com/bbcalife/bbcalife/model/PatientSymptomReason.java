package com.bbcalife.bbcalife.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_symptom_reasons")
public class PatientSymptomReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_symptom_id")
    private Long patientSymptomId;

    private String reason;

    @Column(name = "therapy_id")
    private Long therapyId;

    @Column(name = "operation_id")
    private Long operationId;

    @Column(name = "current_course")
    private Integer currentCourse;

    @Column(name = "current_day")
    private Integer currentDay;

    // Relationship to PatientSymptom (Many-to-One)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_symptom_id", insertable = false, updatable = false)
    private PatientSymptom patientSymptom;

    // Constructors, getters and setters

    public PatientSymptomReason() {}

    public Long getId() {
        return id;
    }

    public Long getPatientSymptomId() {
        return patientSymptomId;
    }

    public void setPatientSymptomId(Long patientSymptomId) {
        this.patientSymptomId = patientSymptomId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getTherapyId() {
        return therapyId;
    }

    public void setTherapyId(Long therapyId) {
        this.therapyId = therapyId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Integer getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Integer currentCourse) {
        this.currentCourse = currentCourse;
    }

    public Integer getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Integer currentDay) {
        this.currentDay = currentDay;
    }

    public PatientSymptom getPatientSymptom() {
        return patientSymptom;
    }

    public void setPatientSymptom(PatientSymptom patientSymptom) {
        this.patientSymptom = patientSymptom;
    }
}
