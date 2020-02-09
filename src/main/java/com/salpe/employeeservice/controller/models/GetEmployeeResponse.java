package com.salpe.employeeservice.controller.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class GetEmployeeResponse {
    private final  Employee details;
}
