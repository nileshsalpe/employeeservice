package com.salpe.employeeservice.controller.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class GetEmployeeListResponse {
    private final List<Employee> employees;
    private final int count;
}


