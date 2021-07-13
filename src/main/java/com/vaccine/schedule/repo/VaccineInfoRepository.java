package com.vaccine.schedule.repo;

import com.vaccine.schedule.model.VaccineInfo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface VaccineInfoRepository extends ReactiveCrudRepository <VaccineInfo,String> {


    @Query("select * from VaccineInfo where sDose = $1")
    Flux<VaccineInfo> findBySecondDose(String sDose);

    
}