package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Models.DTOs.ManutencaoDTO;
import com.oceanunity.app.Models.Entities.Manutencao;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.ManutencaoRepository;
import com.oceanunity.app.Repositories.SensorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;
    private final SensorRepository sensorRepository;
    private final EmpresaRepository empresaRepository;

    public ManutencaoService(ManutencaoRepository manutencaoRepository, SensorRepository sensorRepository, EmpresaRepository empresaRepository) {
        this.manutencaoRepository = manutencaoRepository;
        this.sensorRepository = sensorRepository;
        this.empresaRepository = empresaRepository;
    }
    //Método para criar Manutencao
    public ManutencaoDTO create(ManutencaoDTO data){
        Manutencao manutencao = new Manutencao();
        return new ManutencaoDTO(manutencaoRepository.save(dtoToObject(manutencao, data)));
    }

    //Método para buscar todas Manutencoes
    @Transactional

    public Page<ManutencaoDTO> findAllPageable(Pageable pageable){
        return manutencaoRepository.findAll(pageable).map(ManutencaoDTO::new);
    }

    //Método para atualizar Manutencao
    @Transactional
    public void update(ManutencaoDTO data){
        Manutencao manutencao = manutencaoRepository.findById(data.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Manutenção"));
        manutencaoRepository.save(dtoToObject(manutencao, data));
    }

    //Método para deletar Manutencao
    @Transactional
    public void delete(Long id){
        manutencaoRepository.deleteById(id);
    }

    public Manutencao dtoToObject(Manutencao manutencao, ManutencaoDTO data){
        manutencao.setId(data.getId());
        manutencao.setDescricao(data.getDescricao());
        manutencao.setData(data.getData());
        manutencao.setSensor(sensorRepository.findById(data.getSensorId())
                .orElseThrow(()->new ObjectNotFoundException("Sensor")));
        manutencao.setEmpresa(empresaRepository.findById(data.getEmpresaId())
                .orElseThrow(()->new ObjectNotFoundException("Empresa")));

        return manutencao;
    }
}
