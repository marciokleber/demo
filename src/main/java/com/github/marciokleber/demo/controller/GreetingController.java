package com.github.marciokleber.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello!\n");
    }

    @GetMapping("/morning")
    public ResponseEntity<String> goodMorning(){
        return ResponseEntity.status(HttpStatus.OK).body("Good Morning!\n");
    }

    @GetMapping("/afternoon")
    public ResponseEntity<String> goodAfternoon(){
        return ResponseEntity.status(HttpStatus.OK).body("Good Afternoon!\n");
    }

    @GetMapping("/evening")
    public ResponseEntity<String> goodEvening(){
        return ResponseEntity.status(HttpStatus.OK).body("Good Evening!\n");
    }
}
