package com.tyss.jspiders.repository;

import com.tyss.jspiders.entity.Employee;
import com.tyss.jspiders.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
