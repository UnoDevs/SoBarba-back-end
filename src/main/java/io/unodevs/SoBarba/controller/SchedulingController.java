package io.unodevs.SoBarba.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.unodevs.SoBarba.dto.SchedulingDTO;
import io.unodevs.SoBarba.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Controlador de Agendamento")
@RestController
@RequestMapping("/scheduling")
public class SchedulingController {
    @Autowired
    SchedulingService schedulingService;

    @GetMapping
    public ResponseEntity<List<SchedulingDTO>> findAll(){
        return ResponseEntity.ok(schedulingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingDTO> findById(@PathVariable Long id){
        SchedulingDTO response = schedulingService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(description = "Cadastro de Agendamento, possui validações e os segundos não são obrigatórios de envio")
    @PostMapping
    public ResponseEntity<SchedulingDTO> create(@RequestBody SchedulingDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
                .toUri();
        SchedulingDTO response = schedulingService.create(dto);
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchedulingDTO> update(@PathVariable Long id, @RequestBody SchedulingDTO schedulingDTO){
        SchedulingDTO response = schedulingService.updateById(id,schedulingDTO);
        return ResponseEntity.ok(schedulingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SchedulingDTO> delete(@PathVariable Long id){
        schedulingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
