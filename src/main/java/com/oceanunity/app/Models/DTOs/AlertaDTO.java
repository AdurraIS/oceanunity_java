package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.Alerta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AlertaDTO {
    private Long id;
    @NotBlank(message = "Campo tipo não pode ser vazio")
    private String tipo;
    @NotBlank(message = "Campo descrição não pode ser vazio")
    private String descricao;
    @NotBlank(message = "Campo data não pode ser vazio")
    private LocalDateTime data;
    @NotBlank(message = "Campo resolução não pode ser vazio")
    private String resolucao;
    @NotNull(message = "Campo id da leitura não pode ser nulo")
    private Long leituraId;

    public AlertaDTO(Alerta alerta) {
        this.id = alerta.getId();
        this.tipo = alerta.getTipo();
        this.descricao = alerta.getDescricao();
        this.data = alerta.getData();
        this.resolucao = alerta.getResolucao();
        this.leituraId = alerta.getLeitura().getId();
    }
}
