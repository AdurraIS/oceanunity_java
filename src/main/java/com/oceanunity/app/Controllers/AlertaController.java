package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.AlertaDTO;
import com.oceanunity.app.Services.AlertaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @GetMapping("/alerta/{id}")
    public ResponseEntity<Page<AlertaDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(alertaService.findAllPageable(pageable));
    }
    @PostMapping
    public ResponseEntity<AlertaDTO> create(@RequestBody @Validated AlertaDTO data){
        AlertaDTO createdAlertaDTO = alertaService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/alertas/" + createdAlertaDTO.getId()))
                .body(createdAlertaDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Validated AlertaDTO data){
        alertaService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        alertaService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
