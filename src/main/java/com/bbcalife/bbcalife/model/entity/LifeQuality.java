package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "life_qualities")
public class LifeQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_id")
    private Long patientId;

    private Boolean dryMouth;
    private String taste;
    private String eyes;
    private Boolean hairLoss;
    private String hairLossAffect;
    private Boolean sick;
    private Boolean flushes;
    private Boolean headache;
    private Integer attractiveness;
    private Integer femininity;
    private Boolean naked;
    private String bodyImage;
    private String futureHealth;
    private Boolean armPain;
    private Boolean armSwelling;
    private Boolean armMovement;
    private Boolean breastPain;
    private Boolean breastSwelling;
    private Boolean breastTenderness;
    private String skin;
    private Integer libido;
    private Boolean sexuallyActive;
    private Integer sexPleasure;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "life_quality_id")
    private MentalHealth mentalHealth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;

    @OneToMany(mappedBy = "lifeQuality", fetch = FetchType.LAZY)
    private List<QuestionnaireReason> reasons;
}

