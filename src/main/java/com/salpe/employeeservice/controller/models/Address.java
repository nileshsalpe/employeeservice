package com.salpe.employeeservice.controller.models;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Address {
    List<String> lines;
    @NotBlank
    String city;
    @NotBlank
    String state;
    @NotBlank
    String country;
}
