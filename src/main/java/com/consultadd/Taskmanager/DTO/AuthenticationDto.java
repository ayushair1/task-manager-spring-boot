package com.consultadd.Taskmanager.DTO;

import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDto {

    private String username;
    private String password;
}
