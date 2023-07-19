package com.raphael.springbootvalidation.exception;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // handling global exception

    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> globalExceptionHandler(Exception exception){
        APIErrorResponse apiErrorResponse = APIErrorResponse.builder()
                .errorMessage(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .isSuccessful(false)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .path()
                .build();
        return new ResponseEntity<> (apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//        return ResponseEntity.ok(apiErrorResponse);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorResponse);
    }

    // handling specific exception

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<APIErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
        APIErrorResponse apiErrorResponse = APIErrorResponse.builder()
                .errorMessage(resourceNotFoundException.getMessage())
                .timestamp(LocalDateTime.now())
                .isSuccessful(false)
                .status(HttpStatus.NOT_FOUND)
                .build();
//         return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND); TODO: any of the return responses works fine
        return ResponseEntity.ok(apiErrorResponse);
    }

    // handling custom validation errors

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        // TODO: Create a new map of strings
        Map<String, String> errorResponse = new HashMap<>();
        // TODO: This will iterate through each error, get the field name & message, put them in the map & return it
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorResponse.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        // TODO: Create a new map of strings
        Map<String, String> errorResponse = new HashMap<>();
        // TODO: This will iterate through each error, get the field name & message, put them in the map & return it
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach((error) -> {
            errorResponse.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException){
        APIErrorResponse apiErrorResponse = APIErrorResponse.builder()
                .errorMessage(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage())
                .timestamp(LocalDateTime.now())
                .isSuccessful(false)
                .status(HttpStatus.BAD_REQUEST)
                .path()
                .build();
        // return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND); TODO: any of the return responses works fine
        return ResponseEntity.ok(apiErrorResponse);
    }

}
