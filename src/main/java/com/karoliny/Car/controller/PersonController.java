package com.karoliny.Car.controller;

import com.karoliny.Car.dto.PersonDtoRequest;
import com.karoliny.Car.dto.PersonDtoResponse;
import com.karoliny.Car.exception.InvalidBrandException;
import com.karoliny.Car.exception.CarNotFoundException;
import com.karoliny.Car.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cars")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody PersonDtoRequest personDtoRequest){
        try {
            personService.registerDb(personDtoRequest);
            return ResponseEntity.ok("Successfully saved!");
        } catch (InvalidBrandException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get/{idChassi}")
    public ResponseEntity<?> get(@PathVariable Long idChassi) {
        try {
            PersonDtoResponse car = personService.getCarById(idChassi);
            return ResponseEntity.ok(car);
        } catch (CarNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
