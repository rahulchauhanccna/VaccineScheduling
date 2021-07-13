package com.vaccine.schedule.service;

import com.vaccine.schedule.model.Person;
import com.vaccine.schedule.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Mono<Person> createUser(Person user){
        return personRepository.save(user);
    }

    public Flux<Person> getAllUsers(){
        return personRepository.findAll();
    }

    public Mono<Person> findById(Integer userId){
        return personRepository.findById(userId);
    }

    public Mono<Person> findByNationalId(String nationalId){
        return personRepository.findByNationalId(nationalId);
    }
    
}
