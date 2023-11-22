package com.consultadd.Taskmanager.DTO;


import com.consultadd.Taskmanager.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupDto {
    private String username;
    private String password;
    private String role;

}
