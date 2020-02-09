package com.salpe.employeeservice.controller.errors;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;
}
