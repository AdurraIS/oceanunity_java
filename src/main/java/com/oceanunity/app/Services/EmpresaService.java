package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.EmpresaDTO;
import com.oceanunity.app.Models.Entities.Empresa;
import com.oceanunity.app.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
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
