package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "current_course_jobs")
public class CurrentCourseJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many CurrentCourseJobs belong to one CancerTherapy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancer_therapy_id")
    private CancerTherapy cancerTherapy;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CancerTherapy getCancerTherapy() {
        return cancerTherapy;
    }

    public void setCancerTherapy(CancerTherapy cancerTherapy) {
        this.cancerTherapy = cancerTherapy;
    }
}
