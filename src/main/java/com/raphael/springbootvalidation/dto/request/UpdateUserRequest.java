package com.raphael.springbootvalidation.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateUserRequest {
    @NotNull(message = "firstName is required")
    @NotBlank(message = "firstName is required")
    @Size(min =20, max = 200, message = "lastName must be between 5 and 200 characters")
    private String firstName;

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @Min(value = 5, message = "last name cannot be less than 5 characters")
    @Max(value = 200, message = "last name cannot be more than 200 characters")
    private String lastName;


    @NotNull(message = "email is mandatory")
    @NotBlank(message = "email is mandatory")
    @Email(message = "",regexp = "^[a-zA-Z0-9]")
    private String email;

    @NotNull(message = "password cannot be empty")
    @NotBlank(message = "password cannot be empty")
    @Size(min = 8, max =24, message = "password must be between 5 and 20 characters")
    @Pattern(regexp = "^[0-9a-fA-F]+")
    private String password;
}
