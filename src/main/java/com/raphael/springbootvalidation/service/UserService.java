package com.raphael.springbootvalidation.service;

import com.raphael.springbootvalidation.dto.request.CreateUserRequest;
import com.raphael.springbootvalidation.dto.request.UpdateUserRequest;
import com.raphael.springbootvalidation.dto.response.CreateUserResponse;
import com.raphael.springbootvalidation.dto.response.UpdateUserResponse;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest newUserRequestDto);

    UpdateUserResponse updateUser(String id, UpdateUserRequest updateUserRequest);
}
