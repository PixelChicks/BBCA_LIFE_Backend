package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "cancer_therapies")
public class CancerTherapy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key to Cancer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancer_id")
    private Cancer cancer;

    // Foreign key to Therapy
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapy_id")
    private Therapy therapy;

    @Column(name = "first_course_start_date")
    private LocalDate firstCourseStartDate;

    @Column(name = "therapy_end_date")
    private LocalDate therapyEndDate;

    @Column(name = "current_course")
    private Integer currentCourse;

    @Column(name = "total_courses")
    private Integer totalCourses;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "dose")
    private String dose;

    // User who checked this therapy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checked_by")
    private User checkedBy;

    @Column(name = "checked_on")
    private LocalDateTime checkedOn;

    @Column(name = "last_notification")
    private LocalDateTime lastNotification;

    // Many-to-Many with Medication through patient_therapy_medications join table
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "patient_therapy_medications",
            joinColumns = @JoinColumn(name = "cancer_therapy_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id")
    )
    private Set<Medication> medications;

    // One-to-many with Event
    @OneToMany(mappedBy = "cancerTherapy", fetch = FetchType.LAZY)
    private Set<Event> events;

    // Getters and Setters ...

    // Add your business logic methods here (e.g. access checks) in your service layer

}
