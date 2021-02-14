package com.self.employeemanagersystem.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeUpdateRequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "employee_name", nullable = true, length = 100)
    private String name;
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Column(name = "job_title", nullable = true, length = 100)
    private String jobTitle;
    @Column(name = "image_url", nullable = true, length = 250)
    private String imageUrl;
    @Column(name = "employee_code", nullable = true, length = 100)
    private String employeeCode;
    @Column(name = "phone_number", nullable = true, length = 13)
    private String phoneNumber;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
