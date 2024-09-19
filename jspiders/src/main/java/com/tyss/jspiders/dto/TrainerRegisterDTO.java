package com.tyss.jspiders.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TrainerRegisterDTO {
    private String trainerId;
    private String name;
    private String password;
}
