package io.unodevs.SoBarba.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.unodevs.SoBarba.dto.BarberShopDTO;
import io.unodevs.SoBarba.service.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Controlador de Barbeiras")
@RestController
@RequestMapping("/barbershop")
public class BarberShopController {

    @Autowired
    private BarberShopService barberShopService;

    @GetMapping
    public ResponseEntity<List<BarberShopDTO>> findAll() {
        return new ResponseEntity<>(barberShopService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberShopDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(barberShopService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BarberShopDTO> create(@RequestBody BarberShopDTO barberShop) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(barberShop.getId()).toUri();
        BarberShopDTO response = barberShopService.create(barberShop);
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarberShopDTO> update(@RequestBody BarberShopDTO barberShop, @PathVariable Long id) {
        return new ResponseEntity<>(barberShopService.updateById(barberShop, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BarberShopDTO> delete(@PathVariable Long id) {
        barberShopService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
