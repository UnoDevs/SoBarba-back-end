package io.unodevs.SoBarba.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.unodevs.SoBarba.dto.PersonDTO;
import io.unodevs.SoBarba.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Controlador de Pessoa")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll(){
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id){
        PersonDTO personReturn = personService.findById(id);
        return new ResponseEntity<>(personReturn, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(person.getId()).toUri();
        PersonDTO response = personService.create(person);
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody PersonDTO person){
        PersonDTO response = personService.updateById(id, person);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonDTO> delete(@PathVariable Long id){
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
