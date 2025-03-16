package io.unodevs.SoBarba.controller;

import io.unodevs.SoBarba.model.Cliente;
import io.unodevs.SoBarba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    public ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        Cliente createdCliente = clienteService.create(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }
}
