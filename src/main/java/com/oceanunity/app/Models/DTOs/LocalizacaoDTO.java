package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.Localizacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocalizacaoDTO {

    private Long id;
    @NotNull(message = "Campo latitude não pode ser nulo")
    private int latitude;
    @NotNull(message = "Campo longitude não pode ser nulo")
    private int longitude;
    @NotBlank(message = "Campo descrição não pode ser vazio")
    private String descricao;

    public LocalizacaoDTO(Localizacao localizacao) {
        this.descricao = localizacao.getDescricao();
        this.longitude = localizacao.getLongitude();
        this.latitude = localizacao.getLatitude();
        this.id = localizacao.getId();
    }
}
