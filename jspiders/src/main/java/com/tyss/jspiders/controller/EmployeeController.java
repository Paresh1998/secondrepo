package com.tyss.jspiders.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "api/employee")
@RestController
public class EmployeeController {

    @GetMapping(path="dummy")
    public String dummy() {
        return "Dummy String for employee";
    }


}
