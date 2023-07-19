package com.raphael.springbootvalidation.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class APIErrorResponse {

    private String errorMessage;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private Boolean isSuccessful;
    private String path;

    public APIErrorResponse(String errorMessage, HttpStatus status, String path) {
        this.errorMessage = errorMessage;
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.isSuccessful = Boolean.FALSE;
        this.path = path;
    }
}
