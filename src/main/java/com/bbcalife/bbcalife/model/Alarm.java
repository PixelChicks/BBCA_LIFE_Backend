package com.bbcalife.bbcalife.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alarms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key to PatientTherapyMedication
    @ManyToOne
    @JoinColumn(name = "patient_therapy_medication_id", nullable = false)
    private PatientTherapyMedication patientTherapyMedication;

    private String time; // Assuming time stored as String (e.g., "08:30")

    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;
    private Boolean sunday;
}

