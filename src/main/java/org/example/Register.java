package org.example;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private OffsetDateTime date;

    @ManyToOne
    @JoinColumn(name = "doctor_fio", referencedColumnName = "fio")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "patient_fio", referencedColumnName = "fio")
    private User patient;

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getPatient() {
        return patient;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }


}
