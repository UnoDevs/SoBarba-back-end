package io.unodevs.SoBarba.controller;

import io.unodevs.SoBarba.model.Task;
import io.unodevs.SoBarba.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(task.getId()).toUri();
        Task response = taskService.create(task);
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody Task task, @PathVariable Long id) {
        return new ResponseEntity<>(taskService.update(task, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.delete(id), HttpStatus.OK);
    }
}
