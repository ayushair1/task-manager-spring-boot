package com.consultadd.Taskmanager.Controller;

import com.consultadd.Taskmanager.DTO.LoginDto;
import com.consultadd.Taskmanager.DTO.SignupDto;
import com.consultadd.Taskmanager.entity.UserEntity;
import com.consultadd.Taskmanager.error.TaskNotFoundException;
import com.consultadd.Taskmanager.error.UserAlreadyExist;
import com.consultadd.Taskmanager.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    ResponseEntity<?> signUp(@RequestBody SignupDto signupDTO) throws TaskNotFoundException{


        return ResponseEntity.status(200).body(userService.signUp(signupDTO));
    }
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginDto loginDTO) throws TaskNotFoundException {
        return ResponseEntity.status(200).body(userService.login(loginDTO));

    }
}
