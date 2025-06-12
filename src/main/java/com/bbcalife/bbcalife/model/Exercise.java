package com.bbcalife.bbcalife.model;

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
    @JoinColumn(name = "patient_id") // assumes there's a column named patient_id in exercises table
    private Patient patient;

    private Integer steps;

    @Column(name = "opened_recipes")
    private Integer openedRecipes;

    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    // Store serialized byte array for exercises
    @Lob
    @Column(name = "exercises")
    private byte[] exercisesData;

    @Transient
    private List<String> exercises;  // or appropriate type

    public List<String> getExercises() {
        if (exercises == null && exercisesData != null) {
            try (ByteArrayInputStream bis = new ByteArrayInputStream(exercisesData);
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                exercises = (List<String>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                // handle error or return empty list
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
            // handle error
        }
    }

    // Getters and setters for other fields...

    // Constructors, equals, hashCode, toString etc.

}

