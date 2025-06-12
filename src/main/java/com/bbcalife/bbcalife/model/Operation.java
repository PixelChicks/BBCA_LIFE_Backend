package com.bbcalife.bbcalife.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @ManyToMany
    @JoinTable(
            name = "cancer_operations",
            joinColumns = @JoinColumn(name = "operation_id"),
            inverseJoinColumns = @JoinColumn(name = "cancer_id")
    )
    private Set<Cancer> cancers;

    // Constructors, getters, setters

    public Operation() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Cancer> getCancers() {
        return cancers;
    }

    public void setCancers(Set<Cancer> cancers) {
        this.cancers = cancers;
    }
}

