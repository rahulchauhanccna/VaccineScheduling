package com.vaccine.schedule.service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.vaccine.schedule.model.PersonHealthInfo;

import org.springframework.stereotype.Service;



@Service
public class PersonHealthInfoService {


    public Optional<PersonHealthInfo> getPersonHealthInfoById(String nationalId){

        return this.getData().parallelStream().filter(v-> v.getNationalId().equalsIgnoreCase(nationalId)).findFirst();
    }
    

      private List<PersonHealthInfo> getData(){
        return Arrays.asList(
               new PersonHealthInfo("132-23-323",40,true,false,false),
               new PersonHealthInfo("132-23-322",65,false,false,false),
                new PersonHealthInfo("122-34-323",18,true,false,true),
                new PersonHealthInfo("1231-1232-22",31,true,false,true));
    }
    


}
