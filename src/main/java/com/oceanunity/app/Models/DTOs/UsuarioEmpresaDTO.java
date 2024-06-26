package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.Usuario;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioEmpresaDTO {

    @NotNull(message = "Campo id não pode ser nulo")
    private Long id;
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;
    @Email(message = "Email invalido")
    @NotBlank(message = "Campo email não pode ser vazio")
    private String email;
    @NotBlank(message = "Campo senha não pode ser vazio")
    @Min(value = 6, message = "Senha deve conter no minimo 6 caracteres")
    @Max(value = 16, message = "Senha não pode conter mais de 16 caracteres")
    private String senha;
    private String telefone;

    public UsuarioEmpresaDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.telefone = usuario.getTelefone();
    }
}
