package com.tyss.jspiders.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SuccessResponse {
    private String message;
    private HttpStatus status;
    private String token;
    private Object data;
    private LocalDateTime timestamp;
}
