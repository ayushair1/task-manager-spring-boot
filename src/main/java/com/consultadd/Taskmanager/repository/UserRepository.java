package com.consultadd.Taskmanager.repository;

import com.consultadd.Taskmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    public Optional<UserEntity> findByUsername(String username);

    public UserEntity findFirstByUsername(String username);
//    @Query("select s from UserEntity s where Role.name()=:role")
//    public List<UserEntity> findAllByRole(String role);
}
