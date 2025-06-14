package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "histologies")
public class Histology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cancer_id")
    private Long cancerId;

    private String type;

    @Column(name = "patient_type")
    private String patientType;

    private String t;
    private String n;
    private String m;
    private String g;
    private String er;
    private String pr;
    private String her2;

    @Column(name = "cish_dish_sish")
    private String cishDishSish;

    private String ki67;

    @Column(name = "checked_by")
    private Long checkedBy;

    @Column(name = "checked_on")
    private LocalDateTime checkedOn;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // ManyToOne relationship to Cancer entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancer_id", insertable = false, updatable = false)
    private Cancer cancer;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Long getCancerId() {
        return cancerId;
    }

    public void setCancerId(Long cancerId) {
        this.cancerId = cancerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getHer2() {
        return her2;
    }

    public void setHer2(String her2) {
        this.her2 = her2;
    }

    public String getCishDishSish() {
        return cishDishSish;
    }

    public void setCishDishSish(String cishDishSish) {
        this.cishDishSish = cishDishSish;
    }

    public String getKi67() {
        return ki67;
    }

    public void setKi67(String ki67) {
        this.ki67 = ki67;
    }

    public Long getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(Long checkedBy) {
        this.checkedBy = checkedBy;
    }

    public LocalDateTime getCheckedOn() {
        return checkedOn;
    }

    public void setCheckedOn(LocalDateTime checkedOn) {
        this.checkedOn = checkedOn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Cancer getCancer() {
        return cancer;
    }

    public void setCancer(Cancer cancer) {
        this.cancer = cancer;
    }
}
