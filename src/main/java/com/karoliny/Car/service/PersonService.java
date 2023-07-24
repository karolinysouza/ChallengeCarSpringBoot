package com.karoliny.Car.service;

import com.karoliny.Car.dto.PersonDtoRequest;
import com.karoliny.Car.dto.PersonDtoResponse;
import com.karoliny.Car.entity.Person;
import com.karoliny.Car.exception.PersonNotFoundExeption;
import com.karoliny.Car.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

        public void registerDb(PersonDtoRequest personDtoRequest) {

        Person person = new Person(
                null,
                personDtoRequest.getName(),
                personDtoRequest.getBrand(),
                personDtoRequest.getColor(),
                personDtoRequest.getFabricationYear());
        personRepository.save(person);

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
            throw new PersonNotFoundExeption("Car not found!");
        }
    }
}
