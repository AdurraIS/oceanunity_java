package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.LocalizacaoDTO;
import com.oceanunity.app.Services.LocalizacaoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/localizacoes")
public class LocalizacaoController {
    
    private final LocalizacaoService localizacaoService;

    public LocalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @GetMapping("/")
    public ResponseEntity<Page<LocalizacaoDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(localizacaoService.findAllPageable(pageable));
    }
    @PostMapping
    public ResponseEntity<LocalizacaoDTO> create(@RequestBody @Valid LocalizacaoDTO data){
        LocalizacaoDTO createdLocalizacaoDTO = localizacaoService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/localizacoes/" + createdLocalizacaoDTO.getId()))
                .body(createdLocalizacaoDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid LocalizacaoDTO data){
        localizacaoService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        localizacaoService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
