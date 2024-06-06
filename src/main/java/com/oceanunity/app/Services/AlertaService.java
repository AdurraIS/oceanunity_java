package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.AlertaDTO;
import com.oceanunity.app.Models.Entities.Alerta;
import com.oceanunity.app.Repositories.AlertaRepository;
import com.oceanunity.app.Repositories.LeituraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;
    private final LeituraRepository leituraRepository;

    @Autowired
    public AlertaService(AlertaRepository alertaRepository, LeituraRepository leituraRepository) {
        this.alertaRepository = alertaRepository;
        this.leituraRepository = leituraRepository;
    }

    public Alerta dtoToObject(Alerta alerta, AlertaDTO data){
        alerta.setId(data.getId());
        alerta.setTipo(data.getTipo());
        alerta.setDescricao(data.getDescricao());
        alerta.setData(data.getData());
        alerta.setResolucao(data.getResolucao());
        alerta.setLeitura(leituraRepository.findById(data.getLeituraId())
                .orElseThrow());
        return alerta;
    }
}
