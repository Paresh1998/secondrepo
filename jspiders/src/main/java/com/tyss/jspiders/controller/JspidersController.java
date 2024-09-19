package com.tyss.jspiders.controller;

import com.tyss.jspiders.dto.EmployeeRegisterDTO;
import com.tyss.jspiders.dto.LoginDTO;
import com.tyss.jspiders.dto.StudentRegisterDTO;
import com.tyss.jspiders.dto.TrainerRegisterDTO;
import com.tyss.jspiders.jwt.JwtUtils;
import com.tyss.jspiders.response.SuccessResponse;
import com.tyss.jspiders.service.JspidersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
@RestController
public class JspidersController {
    private final AuthenticationManager authenticationManager;
    private final JspidersService jspidersService;
    private final JwtUtils jwtUtils;

    @PostMapping(path = "register/employee")
    public ResponseEntity<SuccessResponse> registerEmployee(@RequestBody EmployeeRegisterDTO dto) {
        String employeeId = jspidersService.registerEmployee(dto);
        return ResponseEntity.of(Optional.ofNullable(SuccessResponse.builder()
                .message("Registration successful")
                .data(employeeId)
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED)
                .build()));
    }

    @PostMapping(path = "register/trainer")
    public ResponseEntity<SuccessResponse> registerTrainer(@RequestBody TrainerRegisterDTO dto) {
        String trainerId = jspidersService.registerTrainer(dto);
        return ResponseEntity.of(Optional.ofNullable(SuccessResponse.builder()
                .message("Registration successful")
                .data(trainerId)
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED)
                .build()));
    }

    @PostMapping(path = "register/student")
    public ResponseEntity<SuccessResponse> registerStudent(@RequestBody StudentRegisterDTO dto) {
        String studentId = jspidersService.registerStudent(dto);
        return ResponseEntity.of(Optional.ofNullable(SuccessResponse.builder()
                .message("Registration successful")
                .data(studentId)
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED)
                .build()));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<SuccessResponse> login(@RequestBody LoginDTO dto) {

        // Some logic to check username and password
        // authenticationManager.authenticate();

        System.out.println("Login execution starts");
        log.info("User is trying to login with provided username and password");
        authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.getUsername(),dto.getPassword()
                        )
                );
        log.info("Authentication Successful");

        String token = jwtUtils.generateToken(dto.getUsername());

        return ResponseEntity.of(Optional.ofNullable(SuccessResponse.builder()
                .message("Login successful")
                .data(false)
                .token(token)
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.OK)
                .build()));
    }


}
