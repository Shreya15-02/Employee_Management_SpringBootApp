package com.coding.learn.learningRESTAPIs.controller;

import com.coding.learn.learningRESTAPIs.dto.AddStudentRequestDto;
import com.coding.learn.learningRESTAPIs.dto.EmployeeDto;
import com.coding.learn.learningRESTAPIs.entity.Employee;
import com.coding.learn.learningRESTAPIs.repository.EmployeeRepository;
import com.coding.learn.learningRESTAPIs.service.EmployeeService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public  EmployeeController(EmployeeService employeeService){
       this.employeeService = employeeService;
    }
    @GetMapping
        public ResponseEntity<List<EmployeeDto> >getAllEmployee(){
       // return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
        return ResponseEntity.ok(employeeService.getAllEmployee());

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id ){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));

    }

    @PostMapping
    public ResponseEntity<EmployeeDto>createNewEmployee(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteEmployee(@PathVariable Long id ){
        employeeService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable Long id , @RequestBody  AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(employeeService.updateEmployee(id,addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDto>updatePartialEmployee(@PathVariable Long id , @RequestBody Map<String , Object> updates){
        return ResponseEntity.ok(employeeService.updatePartialEmployee(id,updates));
    }

}
