package com.raphael.springbootvalidation.service;

import com.raphael.springbootvalidation.dto.request.CreateUserRequest;
import com.raphael.springbootvalidation.dto.request.UpdateUserRequest;
import com.raphael.springbootvalidation.dto.response.CreateUserResponse;
import com.raphael.springbootvalidation.dto.response.UpdateUserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public CreateUserResponse createUser(CreateUserRequest newUserRequestDto) {
        return null;
    }

    @Override
    public UpdateUserResponse updateUser(String id, UpdateUserRequest updateUserRequest) {
        return null;
    }
}
