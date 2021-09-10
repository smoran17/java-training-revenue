package com.accenture.tagtrainingspring.screening;

import com.accenture.tagtrainingspring.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class ScreeningService {

    @Autowired
    ScreeningDatabase screeningDatabase;

    public ScreeningService() {}

    public ScreeningService(ScreeningDatabase screeningDatabase) {
        this.screeningDatabase = screeningDatabase;
    }

    public boolean isScreened(Screening screening, Patient patient) {
        return screening.getPatient().getId() == patient.getId();
    }

    public LinkedList<Screening> getScreeningList() {
        return screeningDatabase.listScreenings();
    }

    public Screening findName(String name){
        Screening match = null;
        LinkedList<Screening> screenings = getScreeningList();
        for(Screening screening : screenings) {
            if (screening.getPatient().getName().equals(name)) {
                match = screening;
                break;
            }
        }
        return match;

    }
}
