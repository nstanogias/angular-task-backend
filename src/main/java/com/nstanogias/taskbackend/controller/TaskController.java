package com.nstanogias.taskbackend.controller;

import com.nstanogias.taskbackend.model.Task;
import com.nstanogias.taskbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    //@Get Tasks by Username
    @GetMapping("/users/{username}/tasks")
    public List<Task> getAllTasks(@PathVariable String username) {
        return taskRepository.findByUsername(username);
    }

    //@Get Task By Id
    @GetMapping("/users/{username}/tasks/{id}")
    public Task getTask(@PathVariable String username, @PathVariable long id) {
        return taskRepository.findById(id).get();
    }

    //@Edit Task
    @PutMapping("/users/{username}/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String username, @PathVariable long id,
                                           @RequestBody Task task) {
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK);
    }

    //@Delete Task
    @DeleteMapping("/users/{username}/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String username, @PathVariable long id) {
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //@Create Task
    @PostMapping("/users/{username}/tasks")
    public ResponseEntity<Void> createTask(@PathVariable String username, @RequestBody Task task) {
        task.setUsername(username);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(taskRepository.save(task).getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
