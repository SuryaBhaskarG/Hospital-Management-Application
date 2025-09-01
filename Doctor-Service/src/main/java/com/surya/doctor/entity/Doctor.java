package com.surya.doctor.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctorName;
    private String doctorEmail;
    private int age;
    private int experience;
    private String domain;
    private String gender;

    // Constructors
    public Doctor() {}

    public Doctor(String doctorName, String doctorEmail, int age, int experience, String domain, String gender) {
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.age = age;
        this.experience = experience;
        this.domain = domain;
        this.gender = gender;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getDoctorEmail() { return doctorEmail; }
    public void setDoctorEmail(String doctorEmail) { this.doctorEmail = doctorEmail; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
