package com.accenture.tagtrainingspring;

import com.accenture.tagtrainingspring.patient.Gender;
import com.accenture.tagtrainingspring.patient.Patient;
import com.accenture.tagtrainingspring.screening.Screening;
import com.accenture.tagtrainingspring.screening.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TagTrainingSpringApplication {

	@Autowired
	static ScreeningService screeningService;

	public static void main(String[] args) {
		SpringApplication.run(TagTrainingSpringApplication.class, args);
		printWelcomeMessage();
		printlogic();
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

	private static void printlogic(){
		Patient patient = new Patient("John", 1234, LocalDate.of(1960, 01, 01), Gender.MALE);
		Screening screening = new Screening(1000,patient,LocalDate.of(2021,01,01),false);
		System.out.println("Patient: " + patient.getName() + " has a malignant diagnosis of " + screening.isMalignant());
//		ScreeningService screeningService = new ScreeningService();
		System.out.println(screeningService.isPatientScreening(screening,patient));
	}

}
