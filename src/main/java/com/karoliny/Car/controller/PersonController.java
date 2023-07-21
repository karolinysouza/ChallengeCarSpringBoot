package com.karoliny.Car.controller;

import com.karoliny.Car.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cars")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/get")
    public String get(){

        return personService.getString();
    }

}
