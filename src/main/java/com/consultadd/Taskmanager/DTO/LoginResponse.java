package com.consultadd.Taskmanager.DTO;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String refreshToken;
    private String role;
    private Long user_id;

    public void setRole(String role) {
        this.role=role;
    }
    public void setUserId(Long user_id){ this.user_id=user_id;}
}
