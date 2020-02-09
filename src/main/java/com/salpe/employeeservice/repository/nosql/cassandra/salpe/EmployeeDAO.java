package com.salpe.employeeservice.repository.nosql.cassandra.salpe;

import com.salpe.employeeservice.controller.models.Address;
import com.salpe.employeeservice.repository.nosql.cassandra.salpe.EmployeeKey;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Table("employees")
public class EmployeeDAO {
    @PrimaryKey
    private EmployeeKey key;

    @Column
    private String fname;
    private String lname;
    private List<AddressDAO> address;
}
