package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.LeituraDTO;
import com.oceanunity.app.Models.Entities.Leitura;
import com.oceanunity.app.Repositories.LeituraRepository;
import com.oceanunity.app.Repositories.ParametroRepository;
import com.oceanunity.app.Repositories.PoluenteRepository;
import com.oceanunity.app.Repositories.SensorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //Método para criar Leitura
    public LeituraDTO create(LeituraDTO data){
        Leitura leitura = new Leitura();
        return new LeituraDTO(leituraRepository.save(dtoToObject(leitura, data)));
    }

    //Método para buscar todas Leituras
    @Transactional
    public Page<LeituraDTO> findAllPageable(Pageable pageable){
        return leituraRepository.findAll(pageable).map(LeituraDTO::new);
    }

    //Método para atualizar Leitura
    @Transactional
    public void update(LeituraDTO data){
        Leitura leitura = leituraRepository.findById(data.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Leitura"));
        leituraRepository.save(dtoToObject(leitura, data));
    }

    //Método para deletar Leitura
    @Transactional
    public void delete(Long id){
        leituraRepository.deleteById(id);
    }


    public Leitura dtoToObject(Leitura leitura, LeituraDTO data){
        leitura.setId(data.getId());
        leitura.setValor(data.getValor());
        leitura.setData(data.getData());
        leitura.setPoluente(poluenteRepository.findById(data.getPoluenteId())
                .orElseThrow(()->new ObjectNotFoundException("Poluente")));
        leitura.setParametro(parametroRepository.findById(data.getParametroId())
                .orElseThrow(()->new ObjectNotFoundException("Parametro")));
        leitura.setSensor(sensorRepository.findById(data.getSensorId())
                .orElseThrow(()->new ObjectNotFoundException("Sensor")));

        return leitura;
    }
}
