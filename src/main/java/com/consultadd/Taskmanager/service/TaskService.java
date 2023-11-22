package com.consultadd.Taskmanager.service;

import com.consultadd.Taskmanager.entity.Role;
import com.consultadd.Taskmanager.entity.Task;
import com.consultadd.Taskmanager.entity.UserEntity;
import com.consultadd.Taskmanager.error.TaskNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TaskService {

    UserDetailsService userDetailsService();
    public Task saveTask(Task task);

    public List<Task> fetchTaskList();

    public Task fetchTaskByTaskId(Integer taskId) throws TaskNotFoundException;

    public void deleteTaskById(Integer taskId);

    public Task updateTask(Integer taskId, Task task);

    public List<Task> fetchTaskByTaskName(String taskName);

    public List<UserEntity> fetchTaskByRole(String role);

    public List<Task> fetchTaskByUserId(Integer userId);

}
