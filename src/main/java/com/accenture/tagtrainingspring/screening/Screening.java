package com.accenture.tagtrainingspring.screening;

import com.accenture.tagtrainingspring.patient.Patient;

import java.time.LocalDate;

public class Screening {
    private int screeningId;
    private Patient patient;
    private LocalDate dateOfScreening;
    private boolean result;

    public Screening(int screeningId, Patient patient, LocalDate dateOfScreening, boolean result) {
        this.screeningId = screeningId;
        this.patient = patient;
        this.dateOfScreening = dateOfScreening;
        this.result = result;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDateOfScreening() {
        return dateOfScreening;
    }

    public void setDateOfScreening(LocalDate dateOfScreening) {
        this.dateOfScreening = dateOfScreening;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
