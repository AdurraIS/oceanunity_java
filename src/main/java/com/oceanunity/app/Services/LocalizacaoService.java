package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.LocalizacaoDTO;
import com.oceanunity.app.Models.Entities.Localizacao;
import com.oceanunity.app.Repositories.LocalizacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }

    public Localizacao dtoToObject(Localizacao localizacao, LocalizacaoDTO data){
        localizacao.setId(data.getId());
        localizacao.setLatitude(data.getLatitude());
        localizacao.setLongitude(data.getLongitude());
        localizacao.setDescricao(data.getDescricao());

        return localizacao;
    }
}
