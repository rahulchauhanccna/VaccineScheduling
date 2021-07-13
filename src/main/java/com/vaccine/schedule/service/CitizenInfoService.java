package com.vaccine.schedule.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.vaccine.schedule.model.CitizenInfo;

import org.springframework.stereotype.Service;

/**
 * Citizen Info Service gets the data from External Service data is hard coded for now 
 */

@Service
public class CitizenInfoService {

   

    private List<CitizenInfo> getData(){
        return Arrays.asList(
               new CitizenInfo("132-23-323","Suman","Das","Driving Licence"),
               new CitizenInfo("132-23-322","Arjun","Kumar","Driving Licence"),
                new CitizenInfo("JAFAASAS","Rock" ,"Das","Passport"),
                new CitizenInfo("1231-1232-22","Manoj" ,"Singh","Passport"));
    }
    

     public Optional<CitizenInfo> getCitizenInfoById(String nationalId)
    {
        return this.getData().parallelStream().filter(v-> v.getNationalId().equalsIgnoreCase(nationalId)).findFirst();
        
    }
}
