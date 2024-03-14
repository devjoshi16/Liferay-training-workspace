package com.aixtor.employee.spring.mvc.dto;

import com.aixtor.employee.model.Employee;
import java.math.BigInteger;
import java.util.Map;

import java.math.BigInteger;
import java.util.Map;

public class EmployeePojo {
    public BigInteger employeeId;
    public String firstName;
    public String lastName;
    public String email;
    public BigInteger mobileNumber;
    public String address;
    public String departmentName;
    public String designationName;
    public String branchName;
    public BigInteger departmentId;
    public BigInteger designationId;
    public BigInteger branchId;

    public EmployeePojo() {
    }

    public EmployeePojo(BigInteger employeeId, String firstName, String lastName, String email, BigInteger mobileNumber, String address, String departmentName, String designationName, String branchName, BigInteger departmentId, BigInteger designationId, BigInteger branchId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.departmentName = departmentName;
        this.designationName = designationName;
        this.branchName = branchName;
        this.departmentId = departmentId;
        this.designationId = designationId;
        this.branchId = branchId;
    }

    public EmployeePojo(Employee employee, Map<Long, String> branchMap, Map<Long, String> departmentMap, Map<Long, String> designationMap) {
        this.address = employee.getAddress();
        this.branchId = new BigInteger("" + employee.getBranchId());
        this.departmentId = new BigInteger("" + employee.getDepartmentId());
        this.designationId = new BigInteger("" + employee.getDesignationId());
        this.email = employee.getEmail();
        this.employeeId = new BigInteger("" + employee.getEmployeeId());
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.mobileNumber = new BigInteger("" + employee.getMobileNumber());
        this.branchName = (String)branchMap.get(employee.getBranchId());
        this.departmentName = (String)departmentMap.get(employee.getDepartmentId());
        this.designationName = (String)designationMap.get(employee.getDesignationId());
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(BigInteger employeeId) {
        this.employeeId = employeeId;
    }

    public BigInteger getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(BigInteger departmentId) {
        this.departmentId = departmentId;
    }

    public BigInteger getDesignationId() {
        return this.designationId;
    }

    public void setDesignationId(BigInteger designationId) {
        this.designationId = designationId;
    }

    public BigInteger getBranchId() {
        return this.branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDesignationName() {
        return this.designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public BigInteger getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(BigInteger mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

