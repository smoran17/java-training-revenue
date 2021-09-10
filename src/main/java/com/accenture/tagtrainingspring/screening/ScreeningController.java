package com.accenture.tagtrainingspring.screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class ScreeningController {

    @Autowired
    ScreeningService screeningService;

    @GetMapping("/screenings")
    public LinkedList<Screening> getScreenings() {
        return screeningService.getScreeningList();
    }
}
