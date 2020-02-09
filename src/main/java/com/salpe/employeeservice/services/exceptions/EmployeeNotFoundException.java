package com.salpe.employeeservice.services.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class EmployeeNotFoundException extends  RuntimeException {
    private final UUID empId;

    public EmployeeNotFoundException(UUID empId, String message, Throwable cause) {
        super(message, cause);
        this.empId = empId;
    }
}
