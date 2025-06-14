package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@SQLDelete(sql = "UPDATE events SET deleted_at = NOW() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancer_id")
    private Cancer cancer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancer_therapy_id")
    private CancerTherapy cancerTherapy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancer_operation_id")
    private CancerOperation cancerOperation;

    @Column(name = "therapy_course_number")
    private Integer therapyCourseNumber;

    private String title;

    private LocalDateTime datetime;

    @Column(name = "patient_title")
    private String patientTitle;

    @Column(name = "patient_text")
    private String patientText;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public Event() {
    }
}

