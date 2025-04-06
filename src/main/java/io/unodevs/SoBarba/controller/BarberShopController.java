package io.unodevs.SoBarba.controller;

import io.unodevs.SoBarba.model.BarberShop;
import io.unodevs.SoBarba.service.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/barbershop")
public class BarberShopController {

    @Autowired
    private BarberShopService barberShopService;

    @GetMapping
    public ResponseEntity<List<BarberShop>> findAll() {
        return new ResponseEntity<>(barberShopService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberShop> findById(@PathVariable Long id) {
        return new ResponseEntity<>(barberShopService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BarberShop> create(@RequestBody BarberShop barberShop) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(barberShop.getId()).toUri();
        BarberShop response = barberShopService.create(barberShop);
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarberShop> update(@RequestBody BarberShop barberShop, @PathVariable Long id) {
        return new ResponseEntity<>(barberShopService.updateById(barberShop, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BarberShop> delete(@PathVariable Long id) {
        return new ResponseEntity<>(barberShopService.delete(id), HttpStatus.OK);
    }
}
