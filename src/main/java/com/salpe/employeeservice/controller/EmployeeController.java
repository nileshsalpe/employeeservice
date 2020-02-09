package com.salpe.employeeservice.controller;


import com.salpe.employeeservice.controller.models.CreateEmployeeRequest;
import com.salpe.employeeservice.controller.models.GetEmployeeListResponse;
import com.salpe.employeeservice.controller.models.GetEmployeeResponse;
import com.salpe.employeeservice.controller.models.EmployeeConverter;
import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeDAO;
import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeKey;
import com.salpe.employeeservice.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    private final EmployeeConverter employeeConverter;
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService, EmployeeConverter employeeConverter) {
        this.employeeService = employeeService;
        this.employeeConverter = employeeConverter;
    }

    @GetMapping("/employees")
    GetEmployeeListResponse all() {
        List<EmployeeDAO> list =  employeeService.all();
        return GetEmployeeListResponse.builder().
                employees(list.
                        stream().
                        map(e -> employeeConverter.toApiModel(e)).
                        collect(Collectors.toList()))
                .count(list.size())
                .build();
    }

    @PostMapping("/employees")
    GetEmployeeResponse newEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
       return employeeConverter.toGetEmployeeResponse(employeeService.createEmployee(employeeConverter.toCreateEmpDAO(createEmployeeRequest)));

    }

    @GetMapping("/employees/{empId}")
    GetEmployeeResponse getEmployee(@PathVariable  String empId) {
        try {
            return employeeConverter.toGetEmployeeResponse(employeeService.findById(UUID.fromString(empId)));
        }catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found.", ex);
        }
    }

    @DeleteMapping("/employees/{empId}")
    public void delete (@PathVariable  String empId){
        employeeService.delete(empId);
        }
}
