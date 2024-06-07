package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.PoluenteDTO;
import com.oceanunity.app.Models.Entities.Poluente;
import com.oceanunity.app.Repositories.ParametroRepository;
import com.oceanunity.app.Repositories.PoluenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    //Método para criar Poluente
    public PoluenteDTO create(PoluenteDTO data){
        Poluente poluente = new Poluente();
        return new PoluenteDTO(poluenteRepository.save(dtoToObject(poluente, data)));
    }
    //Método para buscar todos Poluentes
    @Transactional
    public Page<PoluenteDTO> findAll(Pageable pageable){
        return poluenteRepository.findAll(pageable).map(PoluenteDTO::new);
    }
    //Método para atualizar Poluente
    @Transactional
    public void update(PoluenteDTO data){
        Poluente poluente = poluenteRepository.findById(data.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Poluente"));
        poluenteRepository.save(dtoToObject(poluente, data));
    }
    //Método para deletar Poluente
    @Transactional
    public void delete(Long id){
        poluenteRepository.deleteById(id);
    }


    public Poluente dtoToObject(Poluente poluente, PoluenteDTO data){
        poluente.setId(data.getId());
        poluente.setNome(data.getNome());
        poluente.setDescricao(data.getDescricao());
        poluente.setParametro(parametroRepository.findById(data.getParametroId())
                .orElseThrow(()->new ObjectNotFoundException("Parametro")));
        return poluente;
    }
}
