package io.unodevs.SoBarba.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.unodevs.SoBarba.dto.CategoryDTO;
import io.unodevs.SoBarba.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@Tag(name = "Controlador de Categoria")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        CategoryDTO categoryReturn = categoryService.findById(id);
        return ResponseEntity.ok(categoryReturn);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
                .toUri();
        CategoryDTO response = categoryService.create(dto);
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        CategoryDTO response = categoryService.updateById(id,categoryDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> delete (@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
