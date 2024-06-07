package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.ParametroDTO;
import com.oceanunity.app.Models.Entities.Parametro;
import com.oceanunity.app.Repositories.ParametroRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ParametroService {

    private final ParametroRepository parametroRepository;

    public ParametroService(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }

    //Método para criar Parametro
    public ParametroDTO create(ParametroDTO data){
        Parametro parametro = new Parametro();
        return new ParametroDTO(parametroRepository.save(dtoToObject(parametro, data)));
    }

    //Método para buscar todos Parametros
    @Transactional
    public Page<ParametroDTO> findAllPageable(Pageable pageable){
        return parametroRepository.findAllPageable(pageable).map(ParametroDTO::new);
    }

    //Método para atualizar Parametro
    @Transactional
    public void update(ParametroDTO data){
        Parametro parametro = parametroRepository.findById(data.getId())
                .orElseThrow(()-> new ObjectNotFoundException("Parametro"));
        parametroRepository.save(dtoToObject(parametro, data));
    }

    //Método para deletar Parametro
    @Transactional
    public void delete(Long id){
        parametroRepository.deleteById(id);
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
