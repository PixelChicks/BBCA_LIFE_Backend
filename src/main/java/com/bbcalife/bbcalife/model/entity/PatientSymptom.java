package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patient_symptoms")
public class PatientSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Integer level;

    @Column(name = "additional_info")
    private String additionalInfo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptom_id", insertable = false, updatable = false)
    private Symptom symptom;

    @OneToMany(mappedBy = "patientSymptom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PatientSymptomReason> reasons;

    public PatientSymptom() {
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public List<PatientSymptomReason> getReasons() {
        return reasons;
    }

    public void setReasons(List<PatientSymptomReason> reasons) {
        this.reasons = reasons;
    }
}

