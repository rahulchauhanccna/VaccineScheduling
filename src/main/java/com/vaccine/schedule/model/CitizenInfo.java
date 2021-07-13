package com.vaccine.schedule.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class CitizenInfo {

    String nationalId;
    String fname;
    String lname;
    String nationalIdType;


}
