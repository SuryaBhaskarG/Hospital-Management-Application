package com.surya.patient.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private int age;
    private String email;
    private String gender;
    private LocalDate dob;
    private double weight;

    // Constructors
    public Patient() {}

    public Patient(String patientName, int age, String email, String gender, LocalDate dob, double weight) {
        this.patientName = patientName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.weight = weight;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}
