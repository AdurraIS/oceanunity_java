package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.PoluenteDTO;
import com.oceanunity.app.Services.PoluenteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/poluentes")
public class PoluenteController {
    
    private final PoluenteService poluenteService;

    public PoluenteController(PoluenteService poluenteService) {
        this.poluenteService = poluenteService;
    }

    @GetMapping("/")
    public ResponseEntity<Page<PoluenteDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(poluenteService.findAll(pageable));
    }
    @PostMapping
    public ResponseEntity<PoluenteDTO> create(@RequestBody @Valid PoluenteDTO data){
        PoluenteDTO createdPoluenteDTO = poluenteService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/poluentes/" + createdPoluenteDTO.getId()))
                .body(createdPoluenteDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid PoluenteDTO data){
        poluenteService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        poluenteService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
