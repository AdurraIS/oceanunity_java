package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.ParametroDTO;
import com.oceanunity.app.Models.Entities.Parametro;
import com.oceanunity.app.Repositories.ParametroRepository;
import org.springframework.stereotype.Service;

@Service
public class ParametroService {

    private final ParametroRepository parametroRepository;

    public ParametroService(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }

    public Parametro dtoToObject(Parametro parametro, ParametroDTO data){
        parametro.setId(data.getId());
        parametro.setNome(data.getNome());
        parametro.setMaxValor(data.getMaxValor());
        parametro.setMinValor(data.getMinValor());
        parametro.setDescricao(data.getDescricao());
        return parametro;
    }
}
