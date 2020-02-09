package com.salpe.employeeservice.repository.nosql.cassandra.salpe;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@Builder
@UserDefinedType("address")
public class AddressDAO {
    List<String> lines;
    String city;
    String state;
    String country;
}
