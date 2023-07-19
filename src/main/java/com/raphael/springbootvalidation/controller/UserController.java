package com.raphael.springbootvalidation.controller;

import com.raphael.springbootvalidation.dto.request.UpdateUserRequest;
import com.raphael.springbootvalidation.dto.response.CreateUserResponse;
import com.raphael.springbootvalidation.dto.response.UpdateUserResponse;
import com.raphael.springbootvalidation.service.UserService;
import com.raphael.springbootvalidation.dto.request.CreateUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest newUserRequestDto){
        CreateUserResponse createUserResponse = userService.createUser(newUserRequestDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse); // No need for @ResponseStatus
//        return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED); // No need for @ResponseStatus
        return ResponseEntity.ok(createUserResponse); // for this you need to use @ResponseStatus at the top of the endpoint to specify the HttpStatus
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @Valid @RequestBody UpdateUserRequest updateUserRequest){
        UpdateUserResponse updateUserResponse = userService.updateUser(id, updateUserRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updateUserResponse);
    }

}
