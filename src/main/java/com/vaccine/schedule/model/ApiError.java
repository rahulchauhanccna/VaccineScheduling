package com.vaccine.schedule.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@Builder
public class ApiError {
    
    private String errorCode;
    private String errorMessage;
    private String developerMessage;
    private String uri;
    private Date timestamp;
}
