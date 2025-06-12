package com.bbcalife.bbcalife.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "mental_health")
public class MentalHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Long lifeQualityId;

    private Boolean depressed;
    private Boolean crying;           // Fixed typo "criyng" to "crying"
    private Boolean insomnia;
    private Boolean weightLoss;
    private Boolean constipation;
    private Integer heartRate;
    private Boolean tired;
    private Boolean anxious;
    private Boolean irritable;
    private Boolean dead;
    private Boolean dissatisfaction; // Fixed typo "disatisfaction"
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

    // Constructors
    public MentalHealth() {}

    // Getters and Setters
    // ... (generate for all fields)

    public Long getId() {
        return id;
    }

    // ... other getters and setters



    public List<QuestionnaireReason> getReasons() {
        return reasons;
    }

    public void setReasons(List<QuestionnaireReason> reasons) {
        this.reasons = reasons;
    }
}

