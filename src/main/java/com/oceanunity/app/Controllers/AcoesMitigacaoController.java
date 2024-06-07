package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.AcoesMitigacaoDTO;
import com.oceanunity.app.Services.AcoesMitigacaoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/acoes")
public class AcoesMitigacaoController {

    private final AcoesMitigacaoService acoesMitigacaoService;

    public AcoesMitigacaoController(AcoesMitigacaoService acoesMitigacaoService) {
        this.acoesMitigacaoService = acoesMitigacaoService;
    }
    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<Page<AcoesMitigacaoDTO>> findAllByEmpresa(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                    @RequestParam(name = "size", defaultValue = "10") int size, long empresaId){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(acoesMitigacaoService.findAllByEmpresa(pageable, empresaId));
    }
    @GetMapping("/poluente/{poluenteId}")
    public ResponseEntity<Page<AcoesMitigacaoDTO>> findAllByPoluente(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                    @RequestParam(name = "size", defaultValue = "10") int size, long poluenteId){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(acoesMitigacaoService.findAllByPoluente(pageable, poluenteId));
    }
    @GetMapping("/empresa/{empresaId}/poluente/{poluenteId}")
    public ResponseEntity<Page<AcoesMitigacaoDTO>> findAllByEmpresaAndPoluente(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                    @RequestParam(name = "size", defaultValue = "10") int size,
                                                                               long empresaId, long poluenteId){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(acoesMitigacaoService.findAllByEmpresaAndPoluente(pageable, empresaId,poluenteId ));
    }

    @GetMapping("/")
    public ResponseEntity<Page<AcoesMitigacaoDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(acoesMitigacaoService.findAllPageable(pageable));
    }
    @PostMapping
    public ResponseEntity<AcoesMitigacaoDTO> create(@RequestBody @Valid AcoesMitigacaoDTO data){
        AcoesMitigacaoDTO createdAcoesMitigacaoDTO = acoesMitigacaoService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/acoes/" + createdAcoesMitigacaoDTO.getId()))
                .body(createdAcoesMitigacaoDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid AcoesMitigacaoDTO data){
        acoesMitigacaoService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        acoesMitigacaoService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
