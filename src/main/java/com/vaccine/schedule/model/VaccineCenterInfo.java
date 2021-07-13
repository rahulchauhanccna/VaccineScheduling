package com.vaccine.schedule.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
@AllArgsConstructor
@Data
@ToString
public class VaccineCenterInfo {

    String centerId;
    String zipCode;
    List <VaccineDetail> vaccineDetail;
 

}
