package com.consultadd.Taskmanager.repository;

import com.consultadd.Taskmanager.entity.Role;
import com.consultadd.Taskmanager.entity.Task;

import com.consultadd.Taskmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    public Task findByTaskName(String taskName);
    //to fetch data there is no default method avaiable here in the repo
    public List<Task> findAllByTaskNameIgnoreCase(String taskName);
//    public Optional<UserEntity> findByUsername(String username);


    @Query("select s from UserEntity s where role='Developer'")
    public List<UserEntity> findAllByRole(String role);

//    @Query("select s from Task s where user_id=:userId ")

    @Query("SELECT t FROM Task t WHERE t.assignee.user_id = :userId")
    public List<Task> findAllByUserId(Integer userId);

}
