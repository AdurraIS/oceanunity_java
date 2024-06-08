package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.EmpresaDTO;
import com.oceanunity.app.Services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/empresas")
public class EmpresaController {
    
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/")
    public ResponseEntity<Page<EmpresaDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(empresaService.findAllPageable(pageable));
    }
    @PostMapping
    public ResponseEntity<EmpresaDTO> create(@RequestBody @Valid EmpresaDTO data){
        EmpresaDTO createdEmpresaDTO = empresaService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/empresas/" + createdEmpresaDTO.getId()))
                .body(createdEmpresaDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid EmpresaDTO data){
        empresaService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
