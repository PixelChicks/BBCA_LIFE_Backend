package com.bbcalife.bbcalife.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "hospitals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @Column(name = "city_id")
    private Long cityId;

    @ManyToMany(mappedBy = "hospitals")
    private List<Doctor> doctors;

}

