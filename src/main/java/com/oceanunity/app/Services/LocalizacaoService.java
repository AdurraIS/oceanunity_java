package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.LocalizacaoDTO;
import com.oceanunity.app.Models.Entities.Localizacao;
import com.oceanunity.app.Repositories.LocalizacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }
    //Método para criar Localizacao
    public LocalizacaoDTO create(LocalizacaoDTO data){
        Localizacao localizacao = new Localizacao();
        return new LocalizacaoDTO(localizacaoRepository.save(dtoToObject(localizacao, data)));
    }

    //Método para buscar todas Localizacoes
    @Transactional
    public Page<LocalizacaoDTO> findAllPageable(Pageable pageable){
        return localizacaoRepository.findAllPageable(pageable).map(LocalizacaoDTO::new);
    }

    //Método para atualizar Localizacao
    @Transactional
    public void update(LocalizacaoDTO data){
        Localizacao localizacao = localizacaoRepository.findById(data.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Localização"));
        localizacaoRepository.save(dtoToObject(localizacao, data));
    }

    //Método para deletar Localizacao
    @Transactional
    public void delete(Long id){
        localizacaoRepository.deleteById(id);
    }


    public Localizacao dtoToObject(Localizacao localizacao, LocalizacaoDTO data){
        localizacao.setId(data.getId());
        localizacao.setLatitude(data.getLatitude());
        localizacao.setLongitude(data.getLongitude());
        localizacao.setDescricao(data.getDescricao());

        return localizacao;
    }
}
