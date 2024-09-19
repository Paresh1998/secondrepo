package com.tyss.jspiders.repository;

import com.tyss.jspiders.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String roleAdmin);
}
