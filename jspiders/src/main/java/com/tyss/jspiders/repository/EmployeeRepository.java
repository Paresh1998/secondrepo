package com.tyss.jspiders.repository;

import com.tyss.jspiders.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
