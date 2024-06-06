package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.UsuarioDTO;
import com.oceanunity.app.Models.Entities.Usuario;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
    }

    public Usuario dtoToObject(Usuario usuario, UsuarioDTO data){
        usuario.setId(data.getId());
        usuario.setNome(data.getNome());
        usuario.setEmail(data.getEmail());
        usuario.setSenha(data.getSenha());
        usuario.setTelefone(data.getTelefone());
        usuario.setEmpresa(empresaRepository.findById(data.getEmpresaId())
                .orElseThrow());

        return usuario;
    }
}
