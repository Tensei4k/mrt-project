package org.example;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AdmissionDateService {
    private final AdmissionDateRepository admissionDateRepository;

    public AdmissionDateService(AdmissionDateRepository admissionDateRepository) {
        this.admissionDateRepository = admissionDateRepository;
    }

    public Byte getDay(Long admissionDateId) {
        AdmissionDate admissionDate = admissionDateRepository.findById(admissionDateId).orElse(null);
        if (admissionDate != null) {
            return admissionDate.getDay();
        }
        return null;
    }

    public Byte getMonth(Long admissionDateId) {
        AdmissionDate admissionDate = admissionDateRepository.findById(admissionDateId).orElse(null);
        if (admissionDate != null) {
            return admissionDate.getMonth();
        }
        return null;
    }

    public Integer getYear(Long admissionDateId) {
        AdmissionDate admissionDate = admissionDateRepository.findById(admissionDateId).orElse(null);
        if (admissionDate != null) {
            return admissionDate.getYear();
        }
        return null;
    }

    public void saveAdmissionDate(Long id, Byte day, Byte month, Integer year) {
        AdmissionDate admissionDate = new AdmissionDate();
        admissionDate.setId(id);
        admissionDate.setDay(day);
        admissionDate.setMonth(month);
        admissionDate.setYear(year);
        admissionDateRepository.save(admissionDate);
    }

    public void updateAdmissionDate(Long id, Byte day, Byte month, Integer year) {
        AdmissionDate existingDate = admissionDateRepository.findById(id).orElse(null);
        if (existingDate != null) {
            existingDate.setDay(day);
            existingDate.setMonth(month);
            existingDate.setYear(year);
            admissionDateRepository.save(existingDate);
        }
    }

    public void deleteAdmissionDate(Long id) {
        admissionDateRepository.deleteById(id);
    }
}