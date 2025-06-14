package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questionnaire_reasons")
public class QuestionnaireReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "life_quality_id")
    private LifeQuality lifeQuality;


    @ManyToOne
    @JoinColumn(name = "mental_health_id")
    private MentalHealth mentalHealth;

    private String reason;

    // Constructors
    public QuestionnaireReason() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LifeQuality getLifeQuality() {
        return lifeQuality;
    }

    public void setLifeQuality(LifeQuality lifeQuality) {
        this.lifeQuality = lifeQuality;
    }

    public MentalHealth getMentalHealth() {
        return mentalHealth;
    }

    public void setMentalHealth(MentalHealth mentalHealth) {
        this.mentalHealth = mentalHealth;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

