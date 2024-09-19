package com.tyss.jspiders.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeRegisterDTO {
    private String employeeId;
    private String name;
    private String password;
}
