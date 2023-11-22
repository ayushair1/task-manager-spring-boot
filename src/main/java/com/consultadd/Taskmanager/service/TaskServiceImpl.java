package com.consultadd.Taskmanager.service;


import com.consultadd.Taskmanager.entity.Role;
import com.consultadd.Taskmanager.entity.Task;
import com.consultadd.Taskmanager.entity.UserEntity;
import com.consultadd.Taskmanager.error.TaskNotFoundException;
import com.consultadd.Taskmanager.repository.TaskRepository;
import com.consultadd.Taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                if(!userRepository.findByUsername(username).isPresent()){

                    try {
                        throw  new TaskNotFoundException("User not found");
                    } catch (TaskNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                }

                return  userRepository.findFirstByUsername(username);


            }
        };
    }


    @Override
    public Task saveTask(Task task) {
        task.setTaskCreatedDate(LocalDate.now());

        return taskRepository.save(task);
    }

    @Override
    public List<Task> fetchTaskList () {
        List<Task> list=taskRepository.findAll();
        return list;
    }
    @Override
    public Task fetchTaskByTaskId(Integer taskId) throws TaskNotFoundException {
        Optional<Task> task=taskRepository.findById(taskId);
        if(!task.isPresent()){
            throw new TaskNotFoundException("Task Not Assign");
        }
        //return taskRepository.findById(taskId).get();
        return task.get();
    }

    @Override
    public void deleteTaskById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateTask(Integer taskId, Task task) {
        Task taskDB=taskRepository.findById(taskId).get();

        if(Objects.nonNull(task.getTaskName()) &&
        !"".equalsIgnoreCase(task.getTaskName())) {
            taskDB.setTaskName(task.getTaskName());
        }

        if(Objects.nonNull(task.getTaskDescription()) &&
                !"".equalsIgnoreCase(task.getTaskDescription())) {
            taskDB.setTaskDescription(task.getTaskDescription());
        }

        if(Objects.nonNull(task.getCurrentStatus()) &&
                !"".equalsIgnoreCase(task.getCurrentStatus())) {
            taskDB.setCurrentStatus(task.getCurrentStatus());
        }
        /*if(Objects.nonNull(task.getTaskCreatedDate()) &&
                !"".equalsIgnoreCase(task.getTaskCreatedDate())) {
            taskDB.setTaskName(task.getTaskName());
        }*/

        if(task.getAssignee() != null && Objects.nonNull(task.getAssignee().getUser_id())) {
//            taskDB.setAssignee().setUser_id(task.getCurrentStatus());
            taskDB.setAssignee(task.getAssignee());
        }

        return taskRepository.save(taskDB);


    }

    @Override
    public List<Task> fetchTaskByTaskName(String taskName) {
        return taskRepository.findAllByTaskNameIgnoreCase(taskName);
    }

    @Override
    public List<UserEntity> fetchTaskByRole(String role) {
        return taskRepository.findAllByRole(role);
    }

    @Override
    public List<Task> fetchTaskByUserId(Integer userId) {
        return taskRepository.findAllByUserId(userId);
    }


}
