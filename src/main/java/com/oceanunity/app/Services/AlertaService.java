package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.AlertaDTO;
import com.oceanunity.app.Models.Entities.Alerta;
import com.oceanunity.app.Repositories.AlertaRepository;
import com.oceanunity.app.Repositories.LeituraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;
    private final LeituraRepository leituraRepository;

    @Autowired
    public AlertaService(AlertaRepository alertaRepository, LeituraRepository leituraRepository) {
        this.alertaRepository = alertaRepository;
        this.leituraRepository = leituraRepository;
    }
    //Método para buscar Alerta por Leitura
    public Set<AlertaDTO> findByLeitura(Long leituraId){
        return alertaRepository.findByLeitura(leituraId).stream().map(AlertaDTO::new).collect(Collectors.toSet());
    }
    // Método para criar Alerta
    public AlertaDTO create(AlertaDTO data){
        Alerta alerta = new Alerta();
        return new AlertaDTO(alertaRepository.save(dtoToObject(alerta, data)));
    }

    // Método para buscar todos Alertas
    @Transactional
    public Page<AlertaDTO> findAllPageable(Pageable pageable){
        return alertaRepository.findAll(pageable).map(AlertaDTO::new);
    }

    // Método para atualizar Alerta
    @Transactional
    public void update(AlertaDTO data){
        Alerta alerta = alertaRepository.findById(data.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Alerta"));
        alertaRepository.save(dtoToObject(alerta, data));
    }

    // Método para deletar Alerta
    @Transactional
    public void delete(Long id){
        alertaRepository.deleteById(id);
    }

    public Alerta dtoToObject(Alerta alerta, AlertaDTO data){
        alerta.setId(data.getId());
        alerta.setTipo(data.getTipo());
        alerta.setDescricao(data.getDescricao());
        alerta.setData(data.getData());
        alerta.setResolucao(data.getResolucao());
        alerta.setLeitura(leituraRepository.findById(data.getLeituraId())
                .orElseThrow(()->new ObjectNotFoundException("Leitura")));
        return alerta;
    }
}
