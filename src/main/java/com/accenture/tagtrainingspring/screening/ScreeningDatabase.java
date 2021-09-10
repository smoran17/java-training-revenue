package com.accenture.tagtrainingspring.screening;

import com.accenture.tagtrainingspring.patient.Gender;
import com.accenture.tagtrainingspring.patient.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.LinkedList;

@Component
public class ScreeningDatabase {

    public LinkedList<Screening> listScreenings() {
        Patient patient1 = new Patient("Joe", 1, LocalDate.of(1960,1,1), Gender.MALE);
        Patient patient2 = new Patient("John", 2, LocalDate.of(1961,1,1), Gender.MALE);
        Patient patient3 = new Patient("Jane", 3, LocalDate.of(1962,1,1), Gender.FEMALE);
        Patient patient4 = new Patient("Jean", 4, LocalDate.of(1963,1,1), Gender.FEMALE);

        Screening screening1 = new Screening(1, patient1, LocalDate.of(2021,1,1), false);
        Screening screening2 = new Screening(2, patient2, LocalDate.of(2021,2,1), false);
        Screening screening3 = new Screening(3, patient3, LocalDate.of(2021,3,1), false);
        Screening screening4 = new Screening(4, patient4, LocalDate.of(2021,4,1), false);

        LinkedList<Screening> screenings = new LinkedList<>();
        screenings.add(screening1);
        screenings.add(screening2);
        screenings.add(screening3);
        screenings.add(screening4);

        return screenings;
    }

}
