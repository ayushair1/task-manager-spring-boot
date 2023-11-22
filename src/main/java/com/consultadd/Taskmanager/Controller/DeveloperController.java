package com.consultadd.Taskmanager.Controller;


import com.consultadd.Taskmanager.entity.Task;
import com.consultadd.Taskmanager.error.TaskNotFoundException;
import com.consultadd.Taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developer")
public class DeveloperController {

    @Autowired
    private TaskService taskService;
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


    @GetMapping("/task")
    public List<Task> fetchTaskList(){
        // LOGGER.info("Inside fetchTaskList of TaskController");
        return taskService.fetchTaskList();
    }


    @GetMapping("/user/{id}")
    public List<Task> fetchTaskByUserId(@PathVariable("id") Integer user_id) throws TaskNotFoundException {
        return  taskService.fetchTaskByUserId(user_id);
    }





}
