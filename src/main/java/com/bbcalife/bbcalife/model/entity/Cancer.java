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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany
    @JoinTable(
            name = "cancer_operations",
            joinColumns = @JoinColumn(name = "cancer_id"),
            inverseJoinColumns = @JoinColumn(name = "operation_id")
    )
    @Where(clause = "deleted_at IS NULL")
    private List<Operation> operations;

    @OneToMany(mappedBy = "cancer", cascade = CascadeType.ALL)
    private List<CancerTherapy> cancerTherapies;

    @OneToMany(mappedBy = "cancer", cascade = CascadeType.ALL)
    private List<CancerOperation> cancerOperations;

    @OneToMany(mappedBy = "cancer", cascade = CascadeType.ALL)
    private List<Histology> histologies;
}
