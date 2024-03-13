package com.wf.bookingApp.repository;

import com.wf.bookingApp.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
