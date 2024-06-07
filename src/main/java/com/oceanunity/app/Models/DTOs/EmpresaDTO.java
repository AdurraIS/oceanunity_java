package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.Empresa;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmpresaDTO {
    @NotNull(message = "Campo id não pode ser nulo")
    private Long id;
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;
    @Email(message = "Email invalido")
    @NotBlank(message = "Campo email não pode ser vazio")
    private String email;
    @NotBlank(message = "Campo UF não pode ser vazio")
    @Max(value = 2)
    @Min(value = 2)
    private String uf;
    private String telefone;

    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.nome = empresa.getNome();
        this.email = empresa.getEmail();
        this.uf = empresa.getUf();
        this.telefone = empresa.getTelefone();
    }
}
