package com.accenture.tagtrainingspring.patient;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Patient {
    private String name;
    private int id;
    private LocalDate dateOfBirth;
    private Gender gender;
}
