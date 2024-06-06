package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.Leitura;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LeituraDTO {

    @NotNull(message = "Campo id não pode ser nulo")
    private Long id;
    @NotNull(message = "Campo valor não pode ser nulo")
    private float valor;
    @NotBlank(message = "Campo data não pode ser vazio")
    private LocalDateTime data;
    @NotNull(message = "Campo id do poluente não pode ser nulo")
    private Long poluenteId;
    @NotNull(message = "Campo id do parametro não pode ser nulo")
    private Long parametroId;
    @NotNull(message = "Campo id do sensor não pode ser nulo")
    private Long sensorId;
    @NotNull(message = "Campo id do alerta não pode ser nulo")
    private Long alertaId;

    public LeituraDTO(Leitura leitura) {
        this.id = leitura.getId();
        this.valor = leitura.getValor();
        this.data = leitura.getData();
        this.poluenteId = leitura.getPoluente().getId();
        this.parametroId = leitura.getParametro().getId();
        this.sensorId = leitura.getSensor().getId();
        this.alertaId = leitura.getAlerta().getId();
    }
}
