package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.SensorDTO;
import com.oceanunity.app.Models.Entities.Sensor;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.LocalizacaoRepository;
import com.oceanunity.app.Repositories.PoluenteRepository;
import com.oceanunity.app.Repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final EmpresaRepository empresaRepository;
    private final LocalizacaoRepository localizacaoRepository;
    private final PoluenteRepository poluenteRepository;
    @Autowired
    public SensorService(SensorRepository sensorRepository, EmpresaRepository empresaRepository, LocalizacaoRepository localizacaoRepository, PoluenteRepository poluenteRepository) {
        this.sensorRepository = sensorRepository;
        this.empresaRepository = empresaRepository;
        this.localizacaoRepository = localizacaoRepository;
        this.poluenteRepository = poluenteRepository;

    }

    public Sensor dtoToObject(Sensor sensor, SensorDTO data){
        sensor.setId(data.getId());
        sensor.setModelo(data.getModelo());
        sensor.setStatus(data.getStatus());
        sensor.setFabricante(data.getFabricante());
        sensor.setData(data.getData());
        sensor.setPoluente(poluenteRepository.findById(data.getPoluenteId())
                .orElseThrow());
        sensor.setLocalizacao(localizacaoRepository.findById(data.getLocalizacao().getId())
                .orElseThrow());
        sensor.setEmpresa(empresaRepository.findById(data.getEmpresaId())
                .orElseThrow());
        return sensor;
    }
}
