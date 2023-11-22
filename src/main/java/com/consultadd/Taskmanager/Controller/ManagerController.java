package com.consultadd.Taskmanager.Controller;


import com.consultadd.Taskmanager.entity.Role;
import com.consultadd.Taskmanager.entity.Task;
import com.consultadd.Taskmanager.entity.UserEntity;
import com.consultadd.Taskmanager.error.TaskNotFoundException;
import com.consultadd.Taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
@AllArgsConstructor
public class ManagerController {

    @Autowired
    private TaskService taskService;

//    @GetMapping("/")
//    public ResponseEntity hello(){
//        return ResponseEntity.ok("Hello From Host");
//    }

    @PostMapping("/task")
    public Task saveTask(@RequestBody Task task) {
        // LOGGER.info("Inside saveTask of TaskController");
        System.out.println(task.getTaskName());
        return taskService.saveTask(task);
    }


    @GetMapping("/task")
    public List<Task> fetchTaskList(){
        // LOGGER.info("Inside fetchTaskList of TaskController");
        return taskService.fetchTaskList();
    }

    @GetMapping("/task/{id}")
    public Task fetchTaskById(@PathVariable("id") Integer taskId) throws TaskNotFoundException {
        return taskService.fetchTaskByTaskId(taskId);
    }


    @PutMapping("/task/{id}")
    public Task updateTask(@PathVariable("id") Integer taskId ,
                           @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/task/{id}")
    public String deleteTaskById(@PathVariable("id") Integer taskId){
        taskService.deleteTaskById(taskId);
        return "Task Deleted Successfully!!!";
    }

    @GetMapping("/task/role/{roles}")
    public List<UserEntity> fetchTaskByRole(@PathVariable("roles") String role) {
        return taskService.fetchTaskByRole(role);
    }
    @GetMapping("/task/name/{name}")
    public List<Task> fetchTaskByName(@PathVariable("name") String taskName){
        return taskService.fetchTaskByTaskName(taskName);
    }

}
