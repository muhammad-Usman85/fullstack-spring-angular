package com.self.employeemanagersystem.controller;

import com.self.employeemanagersystem.model.Employee;
import com.self.employeemanagersystem.model.EmployeeUpdateRequestModel;
import com.self.employeemanagersystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> createEmployee(@Validated @RequestBody Employee employee){
        Employee newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED );
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees = employeeService.findAllEmployees();
        return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeUpdateRequestModel> update(@RequestBody EmployeeUpdateRequestModel employee) {
        EmployeeUpdateRequestModel employeeObj = employeeService.updateEmployee(employee);
        return new ResponseEntity<EmployeeUpdateRequestModel>(employeeObj, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted Successfully",HttpStatus.OK);
    }

}
