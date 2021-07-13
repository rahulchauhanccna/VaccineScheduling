package com.vaccine.schedule.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.ToString;
@AllArgsConstructor
@Data
@ToString
public class PersonHealthInfo {

    String nationalId;
    int age;
    boolean chronic;
    boolean diabetic; 
    boolean covidVaccinated;
}
