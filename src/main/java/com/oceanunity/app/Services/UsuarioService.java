package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectAlreadyExistsException;
import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.UsuarioDTO;
import com.oceanunity.app.Models.Entities.Usuario;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
    }

    //Método para criar Usuario
    public UsuarioDTO create(UsuarioDTO data){
        Usuario user = new Usuario();
        var test = usuarioRepository.findByNomeOrTelefone(data.getNome(), data.getTelefone());
        if(test!=null){
            throw new ObjectAlreadyExistsException("Usuario");
        }
        return new UsuarioDTO(usuarioRepository.save(dtoToObject(user,data)));
    }
    //Método para buscar Usuarios de uma Empresa
    @Transactional
    public Set<UsuarioDTO> findAllByEmpresa(Long id){
        return usuarioRepository.findByEmpresa(id).stream()
                .map(UsuarioDTO::new).collect(Collectors.toSet());
    }
    //Método para atualizar Usuario
    @Transactional
    public void update(UsuarioDTO data){
        Usuario usuario = usuarioRepository.findById(data.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Usuario"));
        usuarioRepository.save(dtoToObject(usuario,data));
    }
    //Método para deletar Usuario
    @Transactional
    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario dtoToObject(Usuario usuario, UsuarioDTO data){
        usuario.setId(data.getId());
        usuario.setNome(data.getNome());
        usuario.setEmail(data.getEmail());
        usuario.setSenha(data.getSenha());
        usuario.setTelefone(data.getTelefone());
        usuario.setEmpresa(empresaRepository.findById(data.getEmpresaId())
                .orElseThrow(()-> new ObjectNotFoundException("Empresa")));

        return usuario;
    }
}
