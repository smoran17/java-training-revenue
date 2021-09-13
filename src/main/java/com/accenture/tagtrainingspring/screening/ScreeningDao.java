package com.accenture.tagtrainingspring.screening;

import com.accenture.tagtrainingspring.patient.Patient;

import java.util.List;

public interface ScreeningDao {
    Screening get(int patientID);
    List<Screening> get();
    void save(Screening screening);
}
