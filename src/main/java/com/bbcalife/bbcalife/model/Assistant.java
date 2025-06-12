package com.bbcalife.bbcalife.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "assistants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Soft delete: mark deleted_at column on delete
@SQLDelete(sql = "UPDATE assistants SET deleted_at = NOW() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Assistant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key to User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String phoneNumber;

    // Soft delete column
    @Column(name = "deleted_at")
    private java.time.LocalDateTime deletedAt;

    // Relationships

    // Assistant has many patients
    @OneToMany(mappedBy = "assistant")
    private List<Patient> patients;

    // Assistant belongs to one hospital
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    // Assistant has many doctors
    @OneToMany(mappedBy = "assistant")
    private List<Doctor> doctors;

    // For activity logging you would implement it in service or use an Aspect or Event Listener in Spring Boot

}

