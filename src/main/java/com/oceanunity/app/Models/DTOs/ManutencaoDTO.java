package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.Manutencao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ManutencaoDTO {
    private Long id;
    @NotBlank(message = "Campo descrição não pod ser vazio")
    private String descricao;
    private LocalDateTime data;
    @NotNull(message = "Campo Id do sensor não pode ser nulo")
    private Long sensorId;
    @NotNull(message = "Camp Id da empresa não pode ser nulo")
    private Long empresaId;

    public ManutencaoDTO(Manutencao manutencao) {
        this.empresaId = manutencao.getEmpresa().getId();
        this.sensorId = manutencao.getSensor().getId();
        this.data = manutencao.getData();
        this.descricao = manutencao.getDescricao();
        this.id = manutencao.getId();
    }
}
