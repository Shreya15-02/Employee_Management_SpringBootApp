package com.coding.learn.learningRESTAPIs.service.Implementation;

import com.coding.learn.learningRESTAPIs.dto.AddStudentRequestDto;
import com.coding.learn.learningRESTAPIs.dto.EmployeeDto;
import com.coding.learn.learningRESTAPIs.entity.Employee;
import com.coding.learn.learningRESTAPIs.repository.EmployeeRepository;
import com.coding.learn.learningRESTAPIs.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDto> employeeDtoList = employees.stream()
                .map(employee -> new EmployeeDto(employee.getId(), employee.getName(), employee.getEmail()))
                .collect(Collectors.toList());

        return employeeDtoList;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID :" + id));
        return modelMapper.map(employee ,EmployeeDto.class);
    }

    @Override
    public EmployeeDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Employee newemployee = modelMapper.map(addStudentRequestDto , Employee.class);
        Employee employee = employeeRepository.save(newemployee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new IllegalArgumentException("Student doesn't exist by id " + id);
        }

        employeeRepository.deleteById(id);

    }

    @Override
    public EmployeeDto updateEmployee(Long id, AddStudentRequestDto addStudentRequestDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID :" + id));

        modelMapper.map(addStudentRequestDto, employee);
         employee =employeeRepository.save(employee);
         return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updatePartialEmployee(Long id, Map<String, Object> updates) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID :" + id));

        updates.forEach((field,value)->{
            switch(field){
                case "name" : employee.setName((String) value);
                break;
                case "email" : employee.setEmail((String) value);
                break;

                default:
                    throw new IllegalArgumentException("Field is not supported");

            }
        });

       Employee saveemployee = employeeRepository.save(employee);
        return modelMapper.map(saveemployee,EmployeeDto.class);
    }

}
