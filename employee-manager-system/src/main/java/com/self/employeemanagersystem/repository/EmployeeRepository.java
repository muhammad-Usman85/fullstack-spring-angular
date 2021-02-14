package com.self.employeemanagersystem.repository;

import com.self.employeemanagersystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    void deleteEmployeeByEmployeeId(Long employeeId);

    Optional<Employee> findEmployeeByEmployeeId(Long employeeId);

}
