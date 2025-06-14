package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;

import java.io.*;
import java.util.List;

@Entity
@Table(name = "exercises")
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exercises_completed")
    private Integer exercisesCompleted;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Integer steps;

    @Column(name = "opened_recipes")
    private Integer openedRecipes;

    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    @Lob
    @Column(name = "exercises")
    private byte[] exercisesData;

    @Transient
    private List<String> exercises;

    public List<String> getExercises() {
        if (exercises == null && exercisesData != null) {
            try (ByteArrayInputStream bis = new ByteArrayInputStream(exercisesData);
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                exercises = (List<String>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return exercises;
    }

    public void setExercises(List<String> exercises) {
        this.exercises = exercises;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(exercises);
            this.exercisesData = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

