package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "admission_date")
public class AdmissionDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Byte day;

    @Column(nullable = false)
    private Byte month;

    @Column(nullable = false)
    private Integer year;

    public Long getId() {
        return id;
    }

    public Byte getDay() {
        return day;
    }

    public Byte getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDay(Byte day) {
        this.day = day;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
