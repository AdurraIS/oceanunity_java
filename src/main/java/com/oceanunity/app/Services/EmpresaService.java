package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.EmpresaDTO;
import com.oceanunity.app.Models.Entities.Empresa;
import com.oceanunity.app.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    // Método para criar Empresa
    public EmpresaDTO create(EmpresaDTO data){
        Empresa empresa = new Empresa();
        return new EmpresaDTO(empresaRepository.save(dtoToObject(empresa, data)));
    }

    // Método para buscar todas Empresas
    @Transactional
    public Page<EmpresaDTO> findAllPageable(Pageable pageable){
        return empresaRepository.findAll(pageable).map(EmpresaDTO::new);
    }

    // Método para atualizar Empresa
    @Transactional
    public void update(EmpresaDTO data){
        Empresa empresa = empresaRepository.findById(data.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Empresa"));
        empresaRepository.save(dtoToObject(empresa, data));
    }

    // Método para deletar Empresa
    @Transactional
    public void delete(Long id){
        empresaRepository.deleteById(id);
    }


    public Empresa dtoToObject(Empresa empresa, EmpresaDTO data){
        empresa.setId(data.getId());
        empresa.setNome(data.getNome());
        empresa.setEmail(data.getEmail());
        empresa.setUf(data.getUf());
        empresa.setTelefone(data.getTelefone());
        return empresa;
    }
}
