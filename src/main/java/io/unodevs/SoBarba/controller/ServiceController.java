package io.unodevs.SoBarba.controller;

import io.unodevs.SoBarba.model.Service;
import io.unodevs.SoBarba.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServiceController {

    @Autowired
    private ServiceService servicoService;

    @GetMapping
    public ResponseEntity<List<Service>> findAll() {
        return new ResponseEntity<>(servicoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> findById(@PathVariable Long id) {
        return new ResponseEntity<>(servicoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Service> create(@RequestBody Service servico) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(servico.getId()).toUri();
        Service resposta = servicoService.create(servico);
        return ResponseEntity.created(uri).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> update(@RequestBody Service servico, @PathVariable Long id) {
        return new ResponseEntity<>(servicoService.update(servico, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Service> delete(@PathVariable Long id) {
        return new ResponseEntity<>(servicoService.delete(id), HttpStatus.OK);
    }
}
