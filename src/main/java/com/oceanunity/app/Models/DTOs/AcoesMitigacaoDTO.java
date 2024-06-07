package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.AcoesMitigacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class AcoesMitigacaoDTO {
    @NotNull(message = "Campo id não pode ser nulo")
    private Long id;
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;
    @NotBlank(message = "Campo descrição não pode ser vazio")
    private String descricao;
    @NotBlank(message = "Campo data do inicio não pode ser vazio")
    private LocalDateTime dataInicio;
    @NotBlank(message = "Campo data do fim não pode ser vazio")
    private LocalDateTime dataFim;
    @NotBlank(message = "Campo status não pode ser vazio")
    private String status;
    @NotBlank(message = "Campo id da empresa não pode ser vazio")
    private Long empresaId;
    @NotBlank(message = "Campo id do poluente não pode ser vazio")
    private Long poluenteId;

    public AcoesMitigacaoDTO(AcoesMitigacao acoesMitigacao) {
        this.id = acoesMitigacao.getId();
        this.nome = acoesMitigacao.getNome();
        this.descricao = acoesMitigacao.getDescricao();
        this.dataInicio = acoesMitigacao.getDataInicio();
        this.dataFim = acoesMitigacao.getDataFim();
        this.status = acoesMitigacao.getStatus();
        this.empresaId = acoesMitigacao.getEmpresa().getId();
        this.poluenteId = acoesMitigacao.getPoluente().getId();
    }
}
