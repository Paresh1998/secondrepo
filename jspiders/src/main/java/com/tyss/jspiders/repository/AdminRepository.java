package com.tyss.jspiders.repository;

import com.tyss.jspiders.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
