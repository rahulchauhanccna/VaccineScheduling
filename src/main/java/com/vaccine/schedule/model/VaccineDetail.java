package com.vaccine.schedule.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
@AllArgsConstructor
@Data
@ToString
public class VaccineDetail {
    String vaccineName;
    int availableQuantity;
}
