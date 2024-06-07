package org.example.jeeexam2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
@CrossOrigin
public class AppRestController {
    @GetMapping
    public ResponseEntity<List<AgencyDto>> getAllAgencies() throws Exception {
        List<AgencyDto> agencies = agencyService.getAllAgencies();
        return new ResponseEntity<>(
                agencies,
                HttpStatus.OK
        );
    }
}
