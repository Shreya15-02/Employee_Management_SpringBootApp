package com.coding.learn.learningRESTAPIs.repository;

import com.coding.learn.learningRESTAPIs.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
