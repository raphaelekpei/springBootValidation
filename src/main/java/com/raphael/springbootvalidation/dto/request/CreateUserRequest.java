package com.raphael.springbootvalidation.dto.request;


import com.raphael.springbootvalidation.constants.Gender;
import com.raphael.springbootvalidation.data.model.Address;
import com.raphael.springbootvalidation.validator.PasswordEqualConstraint;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@Validated
@PasswordEqualConstraint(message = "Confirm Password is invalid")
public class CreateUserRequest {

    @NotNull(message = "first name is required")
    @NotBlank(message = "first name is required")
    @NotEmpty(message = "first name is required")
    @Size(min = 1, max = 200, message = "first name must be between 1 and 200 characters")
    // @Length(min = 1, max = 200, message = "first name must be between 1 and 200 characters")
    private String firstName;

    @NotNull(message = "last name is required")
    @NotBlank(message = "last name is required")
    @NotEmpty(message = "last name is required")
    @Size(min = 1, max = 200, message = "last name must be minimum of 1 character and maximum of 200 characters")
    private String lastName;

    @NotNull(message = "This field cannot be empty")
    @NotBlank(message = "This field cannot be empty")
    @Size(min = 4, message = "Username cannot be less than 4 characters !!")
    @Size(max = 10, message = "Username cannot be more than 10 characters")
    private String username;

    @Email(message = "Invalid email address", regexp = "")
    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    // @Length(min = 5, max = 50, message = "Email must be 5 - 50 characters")

    private String emailAddress;

    @NotNull(message = "password is mandatory")
    @NotBlank(message = "password is mandatory")
    @NotEmpty(message = "password is mandatory")
    @Size(min = 8, max = 24, message = "Password must be at least 8 characters")
    // @Length(min = 8, max = 24, message = "Password must be between 8 - 24 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]{8}", message = "password can contain only characters and digits and size must be 8")
    private String password;

    @NotNull(message = "Confirm Password is mandatory")
    @NotBlank(message = "Confirm Password is mandatory")
    @NotEmpty(message = "Confirm Password is mandatory")
    private String confirmPassword;

    @NotEmpty(message = "Number is required")
    @Size(min = 12, max = 12, message = "Number length must be 12 characters")
    @Pattern(regexp = "NB[0-9]+", message = "Number must start with 'NB'")
    private String userNumber;


    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^(?:(?:(?:\\+?234(?:\\h1)?|01)\\h*)?(?:\\(\\d{3}\\)|\\d{3})|\\d{4})(?:\\W*\\d{3})?\\W*\\d{4}$\n",
             message = "Phone number is not valid")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be empty")
    private Address address;

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private Gender gender;

    @NotBlank(message = "Nationality should not be blank")
    private String nationality;

    @NotNull(message = "This field is required")
    @NotBlank(message = "This field is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = "")
    @Pattern(regexp = "")
    @Past(message = "User's birthday must be a date in the past")
    private LocalDate dateOfBirth;

}
