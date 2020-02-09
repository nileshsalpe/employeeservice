package com.salpe.employeeservice.repository.nosql.cassandra.salpe;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@PrimaryKeyClass
@Data
@Builder
public class EmployeeKey {
    @PrimaryKeyColumn(name = "userid", type = PrimaryKeyType.PARTITIONED)
    private UUID userid;
}
