package com.example.exercisecontrollerlayerrestcrud.Controller;

import com.example.exercisecontrollerlayerrestcrud.Api.ApiResponse;
import com.example.exercisecontrollerlayerrestcrud.Model.TaskTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/TaskTracker")
public class TaskTrackerController {

ArrayList<TaskTracker> taskTrackers = new ArrayList<TaskTracker>();

@GetMapping("/get")
public ArrayList<TaskTracker> getTaskTrackers() {
    return taskTrackers;

    }
@PostMapping("/add")
    public ApiResponse addTaskTracker(@RequestBody TaskTracker taskTracker) {
    taskTrackers.add(taskTracker);
    return new ApiResponse(200, "TaskTracker added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTaskTracker(@PathVariable int index, @RequestBody TaskTracker taskTracker) {
     taskTrackers.set(index, taskTracker);
     return new ApiResponse(200, "TaskTracker updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTaskTracker(@PathVariable int index) {
    taskTrackers.remove(index);
    return new ApiResponse(200, "TaskTracker deleted successfully");
    }

    @GetMapping("/get1")
    public ApiResponse searchTaskTracker(@RequestBody String title ) {
    for (TaskTracker taskTracker : taskTrackers) {
        if (taskTracker.getTitle().equals(title)) {
            getTaskTrackers().add(taskTracker);
            return new ApiResponse(200, "TaskTracker Found");
        }
    }
    return null;
    }
@PutMapping("/update1")
    public ApiResponse changeTaskTracker( @RequestBody String status) {
     for (TaskTracker taskTracker : taskTrackers) {
         if (taskTracker.getStatus().equals("done")) {
             taskTracker.setStatus("not done");
             getTaskTrackers().add(taskTracker);
             return new ApiResponse(200, "TaskTracker change successfully");
         }
     }
     return null;
    }
    }



