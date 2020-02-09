package com.salpe.employeeservice.repository.nosql.cassandra.salpe;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CassandraRepository<EmployeeDAO, EmployeeKey> {
}
