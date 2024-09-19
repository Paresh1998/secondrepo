package com.tyss.jspiders.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentRegisterDTO {
    private String studentId;
    private String name;
    private String password;
}
