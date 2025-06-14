package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String type;

    @Column(name = "main_name")
    private String mainName;

    @Column(name = "trade_name")
    private String tradeName;

    private String dose;

    @Column(name = "intake_info")
    private String intakeInfo;

    private String notes;
}

