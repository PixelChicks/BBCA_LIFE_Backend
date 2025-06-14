package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cancers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isRelapse;

    private LocalDate firstDiagnoseDate;

    private LocalDate relapseDate;

    private Boolean isFirstCancer;

    private Boolean isActiveDate;

    private Long checkedBy;

    private LocalDate checkedOn;

    // Relations

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // Many-to-many with Operation via cancer_operations pivot table, filtering deleted_at = null in pivot
    @ManyToMany
    @JoinTable(
            name = "cancer_operations",
            joinColumns = @JoinColumn(name = "cancer_id"),
            inverseJoinColumns = @JoinColumn(name = "operation_id")
    )
    @Where(clause = "deleted_at IS NULL")
    private List<Operation> operations;

    // Breast operations - filtered by type = 'breast' (custom query needed)
    // Same for armpit operations

    // CancerTherapies: OneToMany relationship
    @OneToMany(mappedBy = "cancer", cascade = CascadeType.ALL)
    private List<CancerTherapy> cancerTherapies;

    // CancerOperations: OneToMany relationship (assuming this is a separate entity from Operation)
    @OneToMany(mappedBy = "cancer", cascade = CascadeType.ALL)
    private List<CancerOperation> cancerOperations;

    // Histologies: OneToMany
    @OneToMany(mappedBy = "cancer", cascade = CascadeType.ALL)
    private List<Histology> histologies;

    // You can implement custom methods or repository queries for filtering active therapies, preoperative, postoperative, etc.

    // Note: For pivot table fields like withPivot in Laravel, you'd create a separate entity for the join table if you want to access those fields directly.

}
