package com.tyss.jspiders;

import com.tyss.jspiders.entity.Admin;
import com.tyss.jspiders.entity.AppUser;
import com.tyss.jspiders.entity.Role;
import com.tyss.jspiders.repository.AdminRepository;
import com.tyss.jspiders.repository.AppUserRepository;
import com.tyss.jspiders.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@SpringBootApplication
public class JspidersApplication {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AppUserRepository appUserRepository;
    private final AdminRepository adminRepository;

    public static void main(String[] args) {
        SpringApplication.run(JspidersApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Optional<Role> roleOP = roleRepository.findByName("ROLE_ADMIN");
            if (!roleOP.isPresent()) {
                Role roleAdmin = roleRepository.save(Role.builder().name("ROLE_ADMIN")
                        .appUsers(new ArrayList<>()).build());
                roleRepository.save(Role.builder().name("ROLE_EMPLOYEE").build());
                roleRepository.save(Role.builder().name("ROLE_TRAINER").build());
                roleRepository.save(Role.builder().name("ROLE_STUDENT").build());

                Admin admin01 = Admin.builder().adminId("Admin01").name("Admin").build();
                adminRepository.save(admin01);
                AppUser appUser= AppUser.builder()
                        .username(admin01.getAdminId())
                        .password(passwordEncoder.encode("qwerty"))
                        .roles(new ArrayList<>())
                        .build();
                appUser.getRoles().add(roleAdmin);
                roleAdmin.getAppUsers().add(appUser);
                appUserRepository.save(appUser);
            }

        };
    }
}
