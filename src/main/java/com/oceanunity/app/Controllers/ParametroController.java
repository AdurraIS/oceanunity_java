package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.ParametroDTO;
import com.oceanunity.app.Services.ParametroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/parametros")
public class ParametroController {
    
    private final ParametroService parametroService;

    public ParametroController(ParametroService parametroService) {
        this.parametroService = parametroService;
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<Page<ParametroDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(parametroService.findAllPageable(pageable));
    }
    @PostMapping
    public ResponseEntity<ParametroDTO> create(@RequestBody @Validated ParametroDTO data){
        ParametroDTO createdParametroDTO = parametroService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/parametros/" + createdParametroDTO.getId()))
                .body(createdParametroDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Validated ParametroDTO data){
        parametroService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        parametroService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
