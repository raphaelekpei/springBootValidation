package com.raphael.springbootvalidation.data.model;



import com.raphael.springbootvalidation.constants.Gender;
import com.raphael.springbootvalidation.constants.UserRole;
import com.raphael.springbootvalidation.constants.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Column(name = "user_id")
    private Long id;

   @Column(name = "first_name", length = 150, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 150, nullable = false)
    private String lastName;
    private String username;

    private String userNumber;
    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String emailAddress;
    @Column(length = 10, nullable = false)
    private String password;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private Long addressId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String nationality;
    private LocalDate dateOfBirth;

    // Note: I want to implement the code such that when the user fills in their date of birth, it calculates the age and
    // throws an exception:
    // if the age is more than 50, or
    // if the age is less than 18

    @Min(value = 18, message = "Cannot be less than 18 years old")
    @Max(value = 35, message = "Cannot be more than 35 years old")
    private Integer age;


    // Get day of birth in String from date of birth
    @Transient
    private MultipartFile image;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    private String created_by;
    private String updated_by;
    private String deleted_by;

    public User(String firstName, String lastName, String username, String emailAddress, String password, String phoneNumber, Address address, Gender gender, String nationality, LocalDate dateOfBirth, MultipartFile image, UserRole userRole, UserStatus userStatus, String created_by, String updated_by, String deleted_by) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears(); // Age gotten from date of birth
        this.image = image;
        this.userRole = userRole;
        this.userStatus = userStatus;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.deleted_at = LocalDateTime.now();
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.deleted_by = deleted_by;
    }
}
