package com.consultadd.Taskmanager.service;

import com.consultadd.Taskmanager.DTO.LoginDto;
import com.consultadd.Taskmanager.DTO.SignupDto;
import com.consultadd.Taskmanager.entity.UserEntity;
import com.consultadd.Taskmanager.error.TaskNotFoundException;
import com.consultadd.Taskmanager.error.UserAlreadyExist;

import java.util.List;

public interface UserService {
    Object signUp(SignupDto signupDto) throws TaskNotFoundException;

    Object login(LoginDto loginDto) throws TaskNotFoundException;

}
