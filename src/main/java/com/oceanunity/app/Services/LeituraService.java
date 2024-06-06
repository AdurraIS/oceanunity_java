package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.LeituraDTO;
import com.oceanunity.app.Models.Entities.Leitura;
import com.oceanunity.app.Repositories.LeituraRepository;
import com.oceanunity.app.Repositories.ParametroRepository;
import com.oceanunity.app.Repositories.PoluenteRepository;
import com.oceanunity.app.Repositories.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class LeituraService {
    private final LeituraRepository leituraRepository;
    private final PoluenteRepository poluenteRepository;
    private final ParametroRepository parametroRepository;
    private final SensorRepository sensorRepository;

    public LeituraService(LeituraRepository leituraRepository, PoluenteRepository poluenteRepository, ParametroRepository parametroRepository, SensorRepository sensorRepository) {
        this.leituraRepository = leituraRepository;
        this.poluenteRepository = poluenteRepository;
        this.parametroRepository = parametroRepository;
        this.sensorRepository = sensorRepository;
    }

    public Leitura dtoToObject(Leitura leitura, LeituraDTO data){
        leitura.setId(data.getId());
        leitura.setValor(data.getValor());
        leitura.setData(data.getData());
        leitura.setPoluente(poluenteRepository.findById(data.getPoluenteId())
                .orElseThrow());
        leitura.setParametro(parametroRepository.findById(data.getParametroId())
                .orElseThrow());
        leitura.setSensor(sensorRepository.findById(data.getSensorId())
                .orElseThrow());

        return leitura;
    }
}
