package com.salpe.employeeservice.controller.models;

import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeDAO;
import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeKey;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EmployeeConverter {
    private final AddressConverter addressConverter;

    public EmployeeConverter(final AddressConverter addressConverter) {
        this.addressConverter = addressConverter;
    }

    public Employee toApiModel(EmployeeDAO empDAO){
        return Employee.builder().userid(empDAO.getKey().
                getUserid()).
                firstName(empDAO.getFname()).
                lastName(empDAO.getLname()).
                addressList(empDAO.
                        getAddress().
                        stream().
                        map(e ->  addressConverter.toApiModel(e)).
                        collect(Collectors.toList())).
                build();
        }

    public EmployeeDAO toCreateEmpDAO(CreateEmployeeRequest emp){
        return EmployeeDAO.builder().
                fname(emp.getFirstName()).
                lname(emp.getLastName()).
                address(emp.getAddressList().
                        stream().map(e ->  addressConverter.toDAO(e)).
                        collect(Collectors.toList()))
                .build();
    }

    public GetEmployeeResponse toGetEmployeeResponse(EmployeeDAO empDAO){
        return GetEmployeeResponse.builder().details(toApiModel(empDAO)).build();
    }

}
