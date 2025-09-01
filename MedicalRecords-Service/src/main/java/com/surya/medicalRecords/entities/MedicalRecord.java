package com.surya.medicalRecords.entities;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;   // FK reference to Patient
    private String disease;
    private String description;
    private LocalDate date;
    private String medicines;

    // Constructors
    public MedicalRecord() {}

    public MedicalRecord(Long patientId, String disease, String description, LocalDate date, String medicines) {
        this.patientId = patientId;
        this.disease = disease;
        this.description = description;
        this.date = date;
        this.medicines = medicines;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getMedicines() { return medicines; }
    public void setMedicines(String medicines) { this.medicines = medicines; }
}
