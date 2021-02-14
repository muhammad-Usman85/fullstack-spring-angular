package com.self.employeemanagersystem.service;

import com.self.employeemanagersystem.model.Employee;
import com.self.employeemanagersystem.model.EmployeeUpdateRequestModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployee(Long id);

    EmployeeUpdateRequestModel updateEmployee(EmployeeUpdateRequestModel employee);

    Employee findEmployeeById(Long id);

}
