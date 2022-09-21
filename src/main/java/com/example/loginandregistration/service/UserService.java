package com.example.loginandregistration.service;

import com.example.loginandregistration.ApiResponse;
import com.example.loginandregistration.model.LoginDto;
import com.example.loginandregistration.model.SignUpDto;

public interface UserService {
    public ApiResponse signUp(SignUpDto signUpDto);
    public ApiResponse login(LoginDto loginDto);
    void validateSignUp(SignUpDto signUpDto);
}
