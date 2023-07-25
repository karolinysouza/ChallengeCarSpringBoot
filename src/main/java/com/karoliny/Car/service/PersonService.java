package com.karoliny.Car.service;

import com.karoliny.Car.dto.PersonDtoRequest;
import com.karoliny.Car.dto.PersonDtoResponse;
import com.karoliny.Car.entity.Person;
import com.karoliny.Car.exception.InvalidBrandException;
import com.karoliny.Car.exception.CarNotFoundException;
import com.karoliny.Car.exception.MissingRequiredFieldException;
import com.karoliny.Car.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void registerDb(PersonDtoRequest personDtoRequest) {
        if (isBlankOrWhitespace(personDtoRequest.getName())
                || isBlankOrWhitespace(personDtoRequest.getBrand())
                || isBlankOrWhitespace(personDtoRequest.getColor())
                || isBlankOrWhitespace(personDtoRequest.getFabricationYear())) {
            throw new MissingRequiredFieldException("Required fields cannot be null or empty.");
        }
        String brand = personDtoRequest.getBrand();
        if (!isValidBrand(brand)) {
            throw new InvalidBrandException("Invalid brand! Valid brands are: Ford, Chevrolet, BMW, Volvo.");
        }

        Person person = new Person(
                null,
                personDtoRequest.getName(),
                brand,
                personDtoRequest.getColor(),
                personDtoRequest.getFabricationYear());

        personRepository.save(person);
    }

    private boolean isBlankOrWhitespace(String str) {
        return str == null || str.trim().isEmpty();
    }

    private boolean isValidBrand(String brand) {
        String[] validBrands = {"Ford", "Chevrolet", "BMW", "Volvo"};

        for (String validBrand : validBrands) {
            if (validBrand.equalsIgnoreCase(brand)) {
                return true;
            }
        }
        return false;
    }

    public PersonDtoResponse getCarById(Long idChassi) {
        Optional<Person> optionalPerson = personRepository.findById(idChassi);

        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();

            PersonDtoResponse personDtoResponse = new PersonDtoResponse(
                    person.getIdChassi(),
                    person.getName(),
                    person.getBrand(),
                    person.getColor(),
                    person.getFabricationYear());

            return personDtoResponse;
        } else {
            throw new CarNotFoundException("Car not found, please check the ID!");
        }
    }
}
