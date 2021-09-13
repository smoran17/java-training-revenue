package com.accenture.tagtrainingspring.screening;

import com.accenture.tagtrainingspring.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class ScreeningService {

    @Autowired
    public ScreeningService() {}

    public boolean isScreened(Screening screening, Patient patient) {
        return screening.getId() == patient.getId();
    }

}
