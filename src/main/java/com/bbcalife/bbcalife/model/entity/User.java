package com.bbcalife.bbcalife.model.entity;

import com.bbcalife.bbcalife.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String firstName;

    private String lastName;

    private String nationalIdNumber;

    // Many users can belong to one city
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(unique = true)
    private String email;

    private String password;
    private String profilePhoto;
    private String lang;
    private Boolean encrypted;
    private String role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Patient patient;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Assistant assistant;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Doctor doctor;
    @OneToMany(mappedBy = "user")
    private List<Reminder> unreadReminders;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == null) return List.of();

        try {
            Role roleEnum = Role.valueOf(this.role.toUpperCase());
            return roleEnum.getAuthorities();
        } catch (IllegalArgumentException e) {
            return List.of();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Patient getPatient() {
        return patient;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public List<Reminder> getUnreadReminders() {
        return unreadReminders;
    }

    // Relations

    public void setUnreadReminders(List<Reminder> unreadReminders) {
        this.unreadReminders = unreadReminders;
    }

    // Role check helpers
    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(role);
    }

    public boolean isDoctor() {
        return "doctor".equalsIgnoreCase(role);
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

//    // Password update method example
//    public boolean updatePassword(String currentPassword, String newPassword, String confirmPassword) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (currentPassword != null && encoder.matches(currentPassword, this.password) && newPassword.equals(confirmPassword)) {
//            this.password = encoder.encode(newPassword);
//            return true;
//        }
//        return false;
//    }

    public boolean isAssistant() {
        return "assistant".equalsIgnoreCase(role);
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public boolean isPatient() {
        return "patient".equalsIgnoreCase(role);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}