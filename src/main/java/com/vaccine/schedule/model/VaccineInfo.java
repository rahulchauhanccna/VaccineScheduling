package com.vaccine.schedule.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("VaccineInfo")
public class VaccineInfo {
    
    @Id
    private Integer id;
    private String fdose;
    private String sdose;
    private Date fDate;
    private Date sDate;
}
