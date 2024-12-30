package com.tripsync.transporter_management.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.List;

@Data
public class ApiErrorResponse {
    private HttpStatus statusName;
    private int status;
    private String message;
    private List<String> errors;
}
