package com.consultadd.Taskmanager.service;

import com.consultadd.Taskmanager.DTO.LoginDto;
import com.consultadd.Taskmanager.DTO.LoginResponse;
import com.consultadd.Taskmanager.DTO.SignupDto;
import com.consultadd.Taskmanager.TaskManagerApplication;
import com.consultadd.Taskmanager.entity.Role;
import com.consultadd.Taskmanager.entity.UserEntity;
import com.consultadd.Taskmanager.error.TaskNotFoundException;
import com.consultadd.Taskmanager.error.UserAlreadyExist;
import com.consultadd.Taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;


//    @Override
//    public Object signUp(UserEntity userModel) throws TaskNotFoundException {
//        Optional<UserEntity> userDb=userRepository.findByUsername(userModel.getUsername());
//        if(userDb.isPresent()){
//            throw new TaskNotFoundException("User Already Exists");
//        }
//        return userRepository.save(userModel);

//        Optional<UserEntity> userDb = userRepository.findByUsername(userModel.getUsername());
//
//        userDb.ifPresent(existingUser -> {
//            throw new RuntimeException("User Already Exists");
//        });
//
//        return userRepository.save(userModel);
//    }

//    @Override
//    public Object login(UserEntity userEntity) throws TaskNotFoundException {
//        Optional<UserEntity> userDb=userRepository.findByUsername(userEntity.getUsername());
//
//
//
//        if(!userDb.isPresent()){
//            throw new TaskNotFoundException("User Not found");
//
//        }
//        String storePassword,currentPassword;
//        storePassword=userDb.get().getPassword();
//        currentPassword=userEntity.getPassword();
//        if(storePassword.equals(currentPassword))
//            return userDb.get();
//        throw new TaskNotFoundException("Invalid Credentials");
//    }

    @Override
    public Object signUp(SignupDto signupDto) throws TaskNotFoundException {
        Optional<UserEntity> userDb=userRepository.findByUsername(signupDto.getUsername());
        if(userDb.isPresent()){
            throw new TaskNotFoundException("User Already Exists");
        }
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(signupDto.getUsername());;
        userEntity.setPassword(signupDto.getPassword());

        if(signupDto.getRole().equals("Manager")){
            userEntity.setRole(Role.Manager);
        }
        else{
            userEntity.setRole(Role.Developer);
        }

        return userRepository.save(userEntity);


    }

    @Override
    public Object login(LoginDto loginDto) throws TaskNotFoundException {
//        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
//
//        if(!authentication.isAuthenticated()){
//
//            throw new TaskNotFoundException("Invalid Credentials");
//        }
        Optional<UserEntity> userDb=userRepository.findByUsername(loginDto.getUsername());
        if(!userDb.isPresent()){
            throw new TaskNotFoundException("Invalid credentials");
        }
//        System.out.println("Hello");

        String storePassword,currentPassword;
        storePassword=userDb.get().getPassword();
        currentPassword=loginDto.getPassword();
        if(!storePassword.equals(currentPassword))
            throw new TaskNotFoundException("Invalid Credentials");
//        if(!passwordEncoder.matches(loginDTO.getPassword(),userDb.get().getPassword())){
////            !userModel.getRole().equals(userDb.get().getRole())
//            throw new EntityNotFoundException("Invalid Credentials");
//        }

        String token= jwtService.generateToken(userDb.get());
        String refreshedToken= jwtService.refreshToken(new HashMap<>(),userDb.get());
        LoginResponse loginResponse=new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setRefreshToken(refreshedToken);

        loginResponse.setRole(userDb.get().getRole().toString());
        loginResponse.setUser_id(Long.valueOf(userDb.get().getUser_id().toString()));

        return loginResponse;

//        Optional<UserEntity> userDb=userRepository.findByUsername(userEntity.getUsername());
//
//
//
//        if(!userDb.isPresent()){
//            throw new TaskNotFoundException("User Not found");
//
//        }
//        String storePassword,currentPassword;
//        storePassword=userDb.get().getPassword();
//        currentPassword=userEntity.getPassword();
//        if(storePassword.equals(currentPassword))
//            return userDb.get();
//        throw new TaskNotFoundException("Invalid Credentials");
    }
}
