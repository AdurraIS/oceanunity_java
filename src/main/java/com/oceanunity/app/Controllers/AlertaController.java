package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.AlertaDTO;
import com.oceanunity.app.Services.AlertaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;

@Controller
@RequestMapping("/api/v1/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }
    @GetMapping("/leitura/{leituraId}")
    public ResponseEntity<Set<AlertaDTO>> findByLeitura(@PathVariable Long leituraId){
        return ResponseEntity.ok(alertaService.findByLeitura(leituraId));

    }
    @GetMapping("/")
    public ResponseEntity<Page<AlertaDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(alertaService.findAllPageable(pageable));
    }
    @PostMapping
    public ResponseEntity<AlertaDTO> create(@RequestBody @Valid AlertaDTO data){
        AlertaDTO createdAlertaDTO = alertaService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/alertas/" + createdAlertaDTO.getId()))
                .body(createdAlertaDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid AlertaDTO data){
        alertaService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alertaService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
