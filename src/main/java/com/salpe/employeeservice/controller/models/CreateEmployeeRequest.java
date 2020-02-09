package com.salpe.employeeservice.controller.models;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Builder
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private List<Address> addressList = Collections.emptyList();
}
