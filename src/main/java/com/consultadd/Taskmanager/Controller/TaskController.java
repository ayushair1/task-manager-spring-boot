//package com.consultadd.Taskmanager.Controller;
//
//
//import com.consultadd.Taskmanager.entity.Task;
//import com.consultadd.Taskmanager.error.TaskNotFoundException;
//import com.consultadd.Taskmanager.service.TaskService;
//import jakarta.validation.Valid;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//import java.util.logging.Logger;
//
//@RestController
//public class TaskController {
//    @Autowired
//    private TaskService taskService;
//
//  // private final Logger LOGGER = (Logger) (Logger) LoggerFactory.getLogger(TaskController.class);
//
//    @PostMapping("/task")
//    public Task saveTask(@Valid @RequestBody Task task) {
//       // LOGGER.info("Inside saveTask of TaskController");
//        return taskService.saveTask(task);
//    }
//
//    @GetMapping("/task")
//    public List<Task> fetchTaskList(){
//      // LOGGER.info("Inside fetchTaskList of TaskController");
//        return taskService.fetchTaskList();
//    }//we are not taking input bacause we send all the data
//
//
//    @GetMapping("/task/{id}")
//    public Task fetchTaskById(@PathVariable("id") Integer taskId) throws TaskNotFoundException {
//        return taskService.fetchTaskByTaskId(taskId);
//    }
//
//    @GetMapping("/task/name/{name}")
//    public Task fetchTaskByName(@PathVariable("name") String taskName){
//        return taskService.fetchTaskByTaskName(taskName);
//    }
//
//    @DeleteMapping("/task/{id}")
//    public String deleteTaskById(@PathVariable("id") Integer taskId){
//        taskService.deleteTaskById(taskId);
//        return "Task Deleted Successfully!!!";
//    }
//
//    @PutMapping("/task/{id}")
//    public Task updateTask(@PathVariable("id") Integer taskId ,
//                           @RequestBody Task task) {
//        return taskService.updateTask(taskId, task);
//    }
//
//
//}
