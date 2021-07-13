package com.vaccine.schedule.handlers;

import lombok.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.ToString;
@AllArgsConstructor
@Data
@ToString
@Builder
public class VaccineSlotRequest {

    String nationalId;
    String zipCode;
}
