package com.salpe.employeeservice.services;


import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeDAO;
import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeKey;
import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeRepository;
import com.salpe.employeeservice.services.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDAO> all() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDAO createEmployee(EmployeeDAO newEmployeeDAO) {
        newEmployeeDAO.setKey(EmployeeKey.builder().userid(UUID.randomUUID()).build());
        return employeeRepository.insert(newEmployeeDAO);
    }

    @Override
    public void delete(String empId) {
        employeeRepository.deleteById(EmployeeKey.builder().userid(UUID.fromString(empId)).build());
    }

    @Override
    public EmployeeDAO findById(UUID id) {
        Optional<EmployeeDAO>  emp = employeeRepository.findById(EmployeeKey.builder().userid(id).build());
        if (emp.isPresent()){
            return emp.get();
        }else{
            throw new EmployeeNotFoundException(id , String.format("Employee with %s is not found", id), new IllegalArgumentException());
        }
    }
}
