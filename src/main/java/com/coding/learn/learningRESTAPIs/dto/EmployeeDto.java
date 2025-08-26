package com.coding.learn.learningRESTAPIs.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long id;
    private String name;
    private String email;
}
