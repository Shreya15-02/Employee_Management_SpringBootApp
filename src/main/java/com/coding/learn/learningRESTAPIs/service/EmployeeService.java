package com.coding.learn.learningRESTAPIs.service;

import com.coding.learn.learningRESTAPIs.dto.AddStudentRequestDto;
import com.coding.learn.learningRESTAPIs.dto.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployee();


    EmployeeDto getEmployeeById(Long id);

    EmployeeDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    EmployeeDto updateEmployee(Long id, AddStudentRequestDto addStudentRequestDto);

    EmployeeDto updatePartialEmployee(Long id, Map<String, Object> updates);
}
