package io.unodevs.SoBarba.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.unodevs.SoBarba.dto.TaskDTO;
import io.unodevs.SoBarba.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Controlador de Serviços")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO task) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(task.getId()).toUri();
        TaskDTO response = taskService.create(task);
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO task, @PathVariable Long id) {
        return new ResponseEntity<>(taskService.updateById(task, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDTO> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
