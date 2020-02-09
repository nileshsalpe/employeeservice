package com.salpe.employeeservice.controller.models;

import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeKey;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Employee {
    private UUID userid;
    private String firstName;
    private String lastName;
    private List<Address> addressList;
}
