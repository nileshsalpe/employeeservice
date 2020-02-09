package com.salpe.employeeservice.controller.models;

import lombok.*;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Address {
    List<String> lines;
    String city;
    String state;
    String country;
}
