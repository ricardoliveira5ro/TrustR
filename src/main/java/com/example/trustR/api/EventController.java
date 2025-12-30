package com.example.trustR.api;

import com.example.trustR.api.dto.EventDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class EventController {

    @PostMapping("/events")
    public ResponseEntity<String> processEvents(@RequestBody EventDTO event) {
        return new ResponseEntity<>("Event Processed", HttpStatus.CREATED);
    }
}
