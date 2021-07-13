package com.vaccine.schedule.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("person")
public class Person {
    @Id
    private int id;
    private String fname;
    private String lname;
    private String phone;
    private String email;
    
}
