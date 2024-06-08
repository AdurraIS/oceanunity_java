package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.ManutencaoDTO;
import com.oceanunity.app.Services.ManutencaoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/manutencaos")
public class ManutencaoController {
    
    private final ManutencaoService manutencaoService;

    public ManutencaoController(ManutencaoService manutencaoService) {
        this.manutencaoService = manutencaoService;
    }

    @GetMapping("/")
    public ResponseEntity<Page<ManutencaoDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(manutencaoService.findAllPageable(pageable));
    }
    @PostMapping
    public ResponseEntity<ManutencaoDTO> create(@RequestBody @Valid ManutencaoDTO data){
        ManutencaoDTO createdManutencaoDTO = manutencaoService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/manutencaos/" + createdManutencaoDTO.getId()))
                .body(createdManutencaoDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid ManutencaoDTO data){
        manutencaoService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        manutencaoService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
