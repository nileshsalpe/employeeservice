package com.salpe.employeeservice.controller.models;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

@Data
@Builder
public class CreateEmployeeRequest {
    @NotBlank(message = "First name can not be null.")
    @Size(min = 2, max = 256, message = "First name should be min 2 to 256 char long.")
    private String firstName;
    @NotBlank(message = "Last name can not be null.")
    @Size(min = 2, max = 256, message = "Last name should be min 2 to 256 char long.")
    private String lastName;
    @NotEmpty(message = "Please enter at least one address.")
    private List<Address> addressList = Collections.emptyList();
}
