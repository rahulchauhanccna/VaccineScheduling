package com.vaccine.schedule.repo;

import com.vaccine.schedule.model.Person;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveCrudRepository <Person,Integer> {


    @Query("select * from persons where phone = $1")
    Mono<Person> findByPhone(String phone);

    @Query("select * from persons where email = $1")
    Mono<Person> findByEmail(String email);

    @Query("select * from persons where nationalId = $1")
    Mono<Person> findByNationalId(String nationalId);
}