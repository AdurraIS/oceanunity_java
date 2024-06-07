package com.oceanunity.app.Services;

import com.oceanunity.app.Models.DTOs.AcoesMitigacaoDTO;
import com.oceanunity.app.Models.Entities.AcoesMitigacao;
import com.oceanunity.app.Repositories.AcoesMitigacaoRepository;
import com.oceanunity.app.Repositories.EmpresaRepository;
import com.oceanunity.app.Repositories.PoluenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // Método para criar AcoesMitigacao
    public AcoesMitigacaoDTO create(AcoesMitigacaoDTO data){
        AcoesMitigacao acoesMitigacao = new AcoesMitigacao();
        return new AcoesMitigacaoDTO(acoesMitigacaoRepository.save(dtoToObject(acoesMitigacao, data)));
    }

    // Método para buscar todas AcoesMitigacao
    @Transactional
    public Page<AcoesMitigacaoDTO> findAllPageable(Pageable pageable){
        return acoesMitigacaoRepository.findAllPageable(pageable).map(AcoesMitigacaoDTO::new);
    }

    // Método para atualizar AcoesMitigacao
    @Transactional
    public void update(AcoesMitigacaoDTO data){
        AcoesMitigacao acoesMitigacao = acoesMitigacaoRepository.findById(data.getId()).orElseThrow();
        acoesMitigacaoRepository.save(dtoToObject(acoesMitigacao, data));
    }

    // Método para deletar AcoesMitigacao
    @Transactional
    public void delete(Long id){
        acoesMitigacaoRepository.deleteById(id);
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
