package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.SensorDTO;
import com.oceanunity.app.Models.Entities.Sensor;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.LocalizacaoRepository;
import com.oceanunity.app.Repositories.PoluenteRepository;
import com.oceanunity.app.Repositories.SensorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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

    //Método para criar Sensor
    public SensorDTO create(SensorDTO data){
        Sensor sensor = new Sensor();
        return new SensorDTO(sensorRepository.save(dtoToObject(sensor, data)));
    }
    //Método para buscar Sensores de uma Empresa
    @Transactional
    public Page<SensorDTO> findAllByEmpresa(Pageable pageable, Long id){
        return sensorRepository.findByEmpresa(pageable, id).map(SensorDTO::new);
    }
    //Método para atualizar Sensor
    @Transactional
    public void update(SensorDTO data){
        Sensor sensor = sensorRepository.findById(data.getId())
                .orElseThrow(()-> new ObjectNotFoundException("Sensor"));
        sensorRepository.save(dtoToObject(sensor, data));
    }
    //Método para deletar Sensor
    @Transactional
    public void delete(Long id){
        sensorRepository.deleteById(id);
    }


    public Sensor dtoToObject(Sensor sensor, SensorDTO data){
        sensor.setId(data.getId());
        sensor.setModelo(data.getModelo());
        sensor.setStatus(data.getStatus());
        sensor.setFabricante(data.getFabricante());
        sensor.setData(data.getData());
        sensor.setPoluente(poluenteRepository.findById(data.getPoluenteId())
                .orElseThrow(()->new ObjectNotFoundException("Poluente")));
        sensor.setLocalizacao(localizacaoRepository.findById(data.getLocalizacao().getId())
                .orElseThrow(()->new ObjectNotFoundException("Localização")));
        sensor.setEmpresa(empresaRepository.findById(data.getEmpresaId())
                .orElseThrow(()->new ObjectNotFoundException("Empresa")));
        return sensor;
    }
}
