package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cancer_operations")
public class CancerOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancer_id")
    private Cancer cancer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @Column(name = "operation_date")
    private LocalDate operationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_cancer_operation_id")
    private CancerOperation parentCancerOperation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checked_by")
    private User user;

    @Column(name = "checked_on")
    private LocalDateTime checkedOn;

    public Long getId() {
        return id;
    }

    public Cancer getCancer() {
        return cancer;
    }

    public void setCancer(Cancer cancer) {
        this.cancer = cancer;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public CancerOperation getParentCancerOperation() {
        return parentCancerOperation;
    }

    public void setParentCancerOperation(CancerOperation parentCancerOperation) {
        this.parentCancerOperation = parentCancerOperation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCheckedOn() {
        return checkedOn;
    }

    public void setCheckedOn(LocalDateTime checkedOn) {
        this.checkedOn = checkedOn;
    }
}
