package com.oceanunity.app.Models.DTOs;


import com.oceanunity.app.Models.Entities.Parametro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParametroDTO {
    @NotNull(message = "Campo id não pode ser nulo")
    private Long id;
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;
    @NotNull(message = "Campo valor maximo não pode ser nulo")
    private float maxValor;
    @NotNull(message = "Campo valor minimo não pode ser nulo")
    private float minValor;
    private String descricao;

    public ParametroDTO(Parametro parametro) {
        this.id = parametro.getId();
        this.nome = parametro.getNome();
        this.maxValor = parametro.getMaxValor();
        this.minValor = parametro.getMinValor();
        this.descricao = parametro.getDescricao();
    }
}
