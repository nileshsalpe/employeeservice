package com.salpe.employeeservice.services;

import com.salpe.employeeservice.controller.models.Employee;
import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeDAO;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<EmployeeDAO> all();

    EmployeeDAO createEmployee(EmployeeDAO newEmployeeDAO);

    void delete(String empId);

    EmployeeDAO findById(UUID id);
}
