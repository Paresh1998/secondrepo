package com.tyss.jspiders.repository;

import com.tyss.jspiders.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
