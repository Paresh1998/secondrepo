package com.tyss.jspiders.service;

import com.tyss.jspiders.dto.EmployeeRegisterDTO;
import com.tyss.jspiders.dto.LoginDTO;
import com.tyss.jspiders.dto.StudentRegisterDTO;
import com.tyss.jspiders.dto.TrainerRegisterDTO;
import com.tyss.jspiders.entity.*;
import com.tyss.jspiders.exception.RoleDoesNotExistException;
import com.tyss.jspiders.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JspidersServiceImpl implements JspidersService {
    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;
    private final TrainerRepository trainerRepository;
    private final StudentRepository studentRepository;
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Override
    public String registerEmployee(EmployeeRegisterDTO dto) {
        Employee employee = Employee.builder()
                .employeeId(dto.getEmployeeId())
                .name(dto.getName())
                .build();
        Role role = roleRepository.findByName("ROLE_EMPLOYEE").orElseThrow(() -> new RoleDoesNotExistException("Role could not be found in the database"));
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        AppUser appUser = AppUser.builder()
                .username(dto.getEmployeeId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(roles)
                .build();
        role.getAppUsers().add(appUser);

        employeeRepository.save(employee);
        appUserRepository.save(appUser);

        return employee.getEmployeeId();
    }

    @Override
    public String registerTrainer(TrainerRegisterDTO dto) {
        Trainer trainer = Trainer.builder()
                .trainerId(dto.getTrainerId())
                .name(dto.getName())
                .build();
        Role role = roleRepository.findByName("ROLE_TRAINER").orElseThrow(() -> new RoleDoesNotExistException("Role could not be found in the database"));
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        AppUser appUser = AppUser.builder()
                .username(dto.getTrainerId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(roles)
                .build();
        role.getAppUsers().add(appUser);

        trainerRepository.save(trainer);
        appUserRepository.save(appUser);

        return trainer.getTrainerId();

    }

    @Override
    public String registerStudent(StudentRegisterDTO dto) {
        Student student = Student.builder()
                .studentId(dto.getStudentId())
                .name(dto.getName())
                .build();
        Role role = roleRepository.findByName("ROLE_STUDENT").orElseThrow(() -> new RoleDoesNotExistException("Role could not be found in the database"));
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        AppUser appUser = AppUser.builder()
                .username(dto.getStudentId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(roles)
                .build();
        role.getAppUsers().add(appUser);

        studentRepository.save(student);
        appUserRepository.save(appUser);

        return student.getStudentId();
    }

}
