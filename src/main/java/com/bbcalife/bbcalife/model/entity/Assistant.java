package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String phoneNumber;

    @Column(name = "deleted_at")
    private java.time.LocalDateTime deletedAt;

    // Relationships
    @OneToMany(mappedBy = "assistant")
    private List<Patient> patients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "assistant")
    private List<Doctor> doctors;
}

