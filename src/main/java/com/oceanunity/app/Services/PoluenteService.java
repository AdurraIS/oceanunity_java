package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.PoluenteDTO;
import com.oceanunity.app.Models.Entities.Poluente;
import com.oceanunity.app.Repositories.ParametroRepository;
import com.oceanunity.app.Repositories.PoluenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoluenteService {

    private final PoluenteRepository poluenteRepository;
    private final ParametroRepository parametroRepository;

    @Autowired
    public PoluenteService(PoluenteRepository poluenteRepository, ParametroRepository parametroRepository) {
        this.poluenteRepository = poluenteRepository;
        this.parametroRepository = parametroRepository;
    }

    public Poluente dtoToObject(Poluente poluente, PoluenteDTO data){
        poluente.setId(data.getId());
        poluente.setNome(data.getNome());
        poluente.setDescricao(data.getDescricao());
        poluente.setParametro(parametroRepository.findById(data.getParametroId())
                .orElseThrow());
        return poluente;
    }
}
