package com.oceanunity.app.Models.DTOs;
import com.oceanunity.app.Models.Entities.Poluente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PoluenteDTO {
    private Long id;
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;
    private String descricao;
    @NotNull(message = "Campo id do parametro não pode ser nulo")
    private Long parametroId;

    public PoluenteDTO(Poluente poluente) {
        this.id = poluente.getId();
        this.nome = poluente.getNome();
        this.descricao = poluente.getDescricao();
        this.parametroId = poluente.getParametro().getId();
    }
}
