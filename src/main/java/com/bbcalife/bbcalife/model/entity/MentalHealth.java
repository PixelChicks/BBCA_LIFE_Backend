package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mental_healths")
public class MentalHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Long lifeQualityId;

    private Boolean depressed;
    private Boolean crying;
    private Boolean insomnia;
    private Boolean weightLoss;
    private Boolean constipation;
    private Integer heartRate;
    private Boolean tired;
    private Boolean anxious;
    private Boolean irritable;
    private Boolean dead;
    private Boolean dissatisfaction;
    private Boolean slower;
    private Boolean morning;
    private Boolean appetite;
    private Boolean sexLife;
    private Boolean clearMind;
    private Boolean hope;
    private Boolean decisions;
    private Boolean usefulness;
    private Boolean fullLife;


    @OneToMany(mappedBy = "mentalHealth", fetch = FetchType.LAZY)
    private List<QuestionnaireReason> reasons;

    public MentalHealth() {
    }

    public Long getId() {
        return id;
    }

    public List<QuestionnaireReason> getReasons() {
        return reasons;
    }

    public void setReasons(List<QuestionnaireReason> reasons) {
        this.reasons = reasons;
    }
}

