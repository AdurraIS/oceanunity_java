package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.AcoesMitigacaoDTO;
import com.oceanunity.app.Models.Entities.AcoesMitigacao;
import com.oceanunity.app.Repositories.AcoesMitigacaoRepository;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.PoluenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcoesMitigacaoService {

    private final AcoesMitigacaoRepository acoesMitigacaoRepository;
    private final EmpresaRepository empresaRepository;
    private final PoluenteRepository poluenteRepository;

    @Autowired
    public AcoesMitigacaoService(AcoesMitigacaoRepository acoesMitigacaoRepository, EmpresaRepository empresaRepository, PoluenteRepository poluenteRepository) {
        this.acoesMitigacaoRepository = acoesMitigacaoRepository;
        this.empresaRepository = empresaRepository;
        this.poluenteRepository = poluenteRepository;
    }

    public AcoesMitigacao dtoToObject(AcoesMitigacao acoesMitigacao, AcoesMitigacaoDTO data){
        acoesMitigacao.setId(data.getId());
        acoesMitigacao.setNome(data.getNome());
        acoesMitigacao.setDescricao(data.getDescricao());
        acoesMitigacao.setDataFim(data.getDataFim());
        acoesMitigacao.setDataInicio(data.getDataInicio());
        acoesMitigacao.setStatus(data.getStatus());
        acoesMitigacao.setEmpresa(empresaRepository.findById(data.getEmpresaId())
                .orElseThrow());
        acoesMitigacao.setPoluente(poluenteRepository.findById(data.getPoluenteId())
                .orElseThrow());
        return acoesMitigacao;
    }
}
