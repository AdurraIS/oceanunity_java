package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.LeituraDTO;
import com.oceanunity.app.Services.LeituraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/leituras")
public class LeituraController {
    
    private final LeituraService leituraService;

    public LeituraController(LeituraService leituraService) {
        this.leituraService = leituraService;
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<Page<LeituraDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(leituraService.findAllPageable(pageable));
    }
    @PostMapping
    public ResponseEntity<LeituraDTO> create(@RequestBody LeituraDTO data){
        LeituraDTO createdLeituraDTO = leituraService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/leituras/" + createdLeituraDTO.getId()))
                .body(createdLeituraDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody LeituraDTO data){
        leituraService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        leituraService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
