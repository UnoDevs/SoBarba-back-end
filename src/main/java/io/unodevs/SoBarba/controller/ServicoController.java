package io.unodevs.SoBarba.controller;

import io.unodevs.SoBarba.model.Servico;
import io.unodevs.SoBarba.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        return new ResponseEntity<>(servicoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id) {
        return new ResponseEntity<>(servicoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody Servico servico) {
        return new ResponseEntity<>(servicoService.create(servico), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> update(@RequestBody Servico servico, @PathVariable Long id) {
        return new ResponseEntity<>(servicoService.update(servico, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> delete(@PathVariable Long id) {
        return new ResponseEntity<>(servicoService.delete(id), HttpStatus.OK);
    }
}
