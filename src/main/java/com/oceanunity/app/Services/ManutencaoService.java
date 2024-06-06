package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.ManutencaoDTO;
import com.oceanunity.app.Models.Entities.Manutencao;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.ManutencaoRepository;
import com.oceanunity.app.Repositories.SensorRepository;
import org.springframework.stereotype.Service;

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

    public Manutencao dtoToObject(Manutencao manutencao, ManutencaoDTO data){
        manutencao.setId(data.getId());
        manutencao.setDescricao(data.getDescricao());
        manutencao.setData(data.getData());
        manutencao.setSensor(sensorRepository.findById(data.getSensorId())
                .orElseThrow());
        manutencao.setEmpresa(empresaRepository.findById(data.getEmpresaId())
                .orElseThrow());

        return manutencao;
    }
}
