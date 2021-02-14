package com.self.employeemanagersystem.service.impl;

import com.self.employeemanagersystem.exception.UserNotFoundException;
import com.self.employeemanagersystem.model.Employee;
import com.self.employeemanagersystem.model.EmployeeUpdateRequestModel;
import com.self.employeemanagersystem.repository.EmployeeRepository;
import com.self.employeemanagersystem.service.EmployeeService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EntityManager entityManager;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EntityManager entityManager) {
        this.employeeRepository = employeeRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteEmployeeByEmployeeId(employeeId);
    }

    @Override
    public EmployeeUpdateRequestModel updateEmployee(EmployeeUpdateRequestModel employeeDetails) {
        Session session = entityManager.unwrap(Session.class);
        EmployeeUpdateRequestModel emp = session.get(EmployeeUpdateRequestModel.class, employeeDetails.getEmployeeId());
        emp.setEmployeeId(employeeDetails.getEmployeeId());
        emp.setName(employeeDetails.getName());
        emp.setEmail(employeeDetails.getEmail());
        emp.setImageUrl(employeeDetails.getImageUrl());
        emp.setJobTitle(employeeDetails.getJobTitle());
        emp.setPhoneNumber(employeeDetails.getPhoneNumber());
        emp.setEmployeeCode(employeeDetails.getEmployeeCode());
        session.beginTransaction();
        session.merge(emp);
        session.getTransaction().commit();
        session.close();
        return emp;
    }

    @Override
    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findEmployeeByEmployeeId(employeeId)
                .orElseThrow(() -> new UserNotFoundException("Employee with this id : " + employeeId + " not found"));
    }


}
