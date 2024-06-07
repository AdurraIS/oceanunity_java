package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.SensorDTO;
import com.oceanunity.app.Services.SensorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/sensores")
public class SensorController {
    
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<Page<SensorDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size,
                                                   Long id){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(sensorService.findAllByEmpresa(pageable, id));
    }
    @PostMapping
    public ResponseEntity<SensorDTO> create(@RequestBody SensorDTO data){
        SensorDTO createdSensorDTO = sensorService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/sensores/" + createdSensorDTO.getId()))
                .body(createdSensorDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody SensorDTO data){
        sensorService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        sensorService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
