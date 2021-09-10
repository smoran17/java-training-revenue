package com.accenture.tagtrainingspring;

import com.accenture.tagtrainingspring.patient.Gender;
import com.accenture.tagtrainingspring.patient.Patient;
import com.accenture.tagtrainingspring.screening.Screening;
import com.accenture.tagtrainingspring.screening.ScreeningDatabase;
import com.accenture.tagtrainingspring.screening.ScreeningService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.LinkedList;

@SpringBootApplication
public class TagTrainingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TagTrainingSpringApplication.class, args);
		printWelcomeMessage();

		Patient patient1 = new Patient("Joe", 1, LocalDate.of(1960,1,1), Gender.MALE);
		Patient patient2 = new Patient("John", 2, LocalDate.of(1961,1,1), Gender.MALE);
		Patient patient3 = new Patient("Jane", 3, LocalDate.of(1962,1,1), Gender.FEMALE);
		Patient patient4 = new Patient("Jean", 4, LocalDate.of(1963,1,1), Gender.FEMALE);

		Screening screening1 = new Screening(1, patient1, LocalDate.of(2021,1,1), false);
		Screening screening2 = new Screening(2, patient2, LocalDate.of(2021,2,1), false);
		Screening screening3 = new Screening(3, patient3, LocalDate.of(2021,3,1), false);
		Screening screening4 = new Screening(4, patient4, LocalDate.of(2021,4,1), false);

		ScreeningService service = new ScreeningService();

		System.out.println("Patient: " + screening1.getPatient().getName() + " has a malignant diagnosis of " + screening1.isResult());
		System.out.println(patient1.getId() + " has a match of " + service.isScreened(screening1, patient1) + " with patient " + screening1.getPatient().getName());

		LinkedList<Screening> screenings = new LinkedList<>();
		screenings.add(screening1);
		screenings.add(screening2);
		screenings.add(screening3);
		screenings.add(screening4);

		for(Screening screening : screenings) {
			System.out.println("Patient: " + screening.getPatient().getName() + " has a malignant diagnosis of " + screening.isResult());
		}

		ScreeningDatabase screeningDatabase = new ScreeningDatabase();
		ScreeningService service2 = new ScreeningService(screeningDatabase);

		for(Screening screening : service2.getScreeningList()) {
			System.out.println("Patient: " + screening.getPatient().getName() + " has a malignant diagnosis of " + screening.isResult());
		}

		Screening screening = service2.findName("John");
		if(screening != null) {
			System.out.println("Screening found for " + screening.getPatient().getName() + ". Result " + screening.isResult());
		} else {
			System.out.println("Screening not found");
		}

	}

	private static void printWelcomeMessage() {
		System.out.println("\n" +
				"  _______       _____   _______        _       _             \n" +
				" |__   __|/\\   / ____| |__   __|      (_)     (_)            \n" +
				"    | |  /  \\ | |  __     | |_ __ __ _ _ _ __  _ _ __   __ _ \n" +
				"    | | / /\\ \\| | |_ |    | | '__/ _` | | '_ \\| | '_ \\ / _` |\n" +
				"    | |/ ____ \\ |__| |    | | | | (_| | | | | | | | | | (_| |\n" +
				"    |_/_/    \\_\\_____|    |_|_|  \\__,_|_|_| |_|_|_| |_|\\__, |\n" +
				"                                                        __/ |\n" +
				"                                                       |___/ \n");
	}

}
