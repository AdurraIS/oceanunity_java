package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SensorDTO {

    private Long id;
    @NotBlank(message = "Campo modelo não pode ser vazio")
    private String modelo;
    @NotBlank(message = "Campo status não pode ser vazio")
    private String status;
    @NotBlank(message = "Campo fabricante não pode ser vazio")
    private String fabricante;
    @NotBlank(message = "Campo data de instalação não pode ser vazio")
    private LocalDateTime data;
    @NotNull(message = "Campo Id do Poluente não pode ser nulo")
    private Long poluenteId;
    @NotNull(message = "Localização não pode ser nula")
    private LocalizacaoDTO localizacao;
    @NotNull(message = "Campo Id da Empresa não pode ser nula")
    private Long empresaId;

    public SensorDTO(Sensor sensor) {
        this.id = sensor.getId();
        this.modelo = sensor.getModelo();
        this.status = sensor.getStatus();
        this.fabricante = sensor.getFabricante();
        this.data = sensor.getData();
        this.poluenteId = sensor.getPoluente().getId();
        this.localizacao = new LocalizacaoDTO(sensor.getLocalizacao());
        this.empresaId = sensor.getEmpresa().getId();
    }
}
