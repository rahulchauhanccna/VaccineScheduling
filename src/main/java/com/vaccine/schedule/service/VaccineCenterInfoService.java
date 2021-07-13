package com.vaccine.schedule.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.vaccine.schedule.model.VaccineCenterInfo;
import com.vaccine.schedule.model.VaccineDetail;

import org.springframework.stereotype.Service;



@Service
public class VaccineCenterInfoService {
    


    public List<VaccineCenterInfo> getVaccineCenterInfo(){

        return getData();

    }

    public List<VaccineCenterInfo> getVaccineCenterInfoByZipCode(String zipCode){

        return getData().stream().filter(v -> v.getZipCode().equalsIgnoreCase(zipCode)).collect(Collectors.toList());

    }



    private List<VaccineCenterInfo> getData(){
        return Arrays.asList(
               new VaccineCenterInfo("vac123","94582" , Arrays.asList( new VaccineDetail("pfizer",2234),new VaccineDetail("moderna",1901),new VaccineDetail("J&J",3901))),
               new VaccineCenterInfo("vac2345","94583" , Arrays.asList( new VaccineDetail("pfizer",5678),new VaccineDetail("moderna",2902),new VaccineDetail("covishield",2201))),
               new VaccineCenterInfo("vac3122","94589" , Arrays.asList( new VaccineDetail("pfizer",7789),new VaccineDetail("moderna",4902),new VaccineDetail("Covishield",3401)))
        );
               
            
    }
    
}
