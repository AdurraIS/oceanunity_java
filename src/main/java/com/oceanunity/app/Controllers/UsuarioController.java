package com.oceanunity.app.Controllers;

import com.oceanunity.app.Models.DTOs.UsuarioDTO;
import com.oceanunity.app.Models.Entities.Usuario;
import com.oceanunity.app.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;

@Controller
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<Set<UsuarioDTO>> findAllByEmpresa(Long id){
        return ResponseEntity.ok(usuarioService.findAllByEmpresa(id));
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody @Validated UsuarioDTO data){
        UsuarioDTO createdUsuarioDTO = usuarioService.create(data);
        return ResponseEntity.created(URI.create("/api/v1/usuarios/" + createdUsuarioDTO.getId()))
                .body(createdUsuarioDTO);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Validated UsuarioDTO data){
        usuarioService.update(data);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
