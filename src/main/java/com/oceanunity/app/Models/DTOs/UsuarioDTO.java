package com.oceanunity.app.Models.DTOs;

import com.oceanunity.app.Models.Entities.Usuario;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;
    @Email(message = "Email invalido")
    @NotBlank(message = "Campo email não pode ser vazio")
    private String email;
    @NotBlank(message = "Campo senha não pode ser vazio")
    @Length(max = 16, min = 6)
    private String senha;
    private String telefone;
    @NotBlank(message = "Campo role não pode ser vazio")
    private String role;
    @NotNull(message = "Usuario deve conter um id de empresa")
    private Long empresaId;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.role = usuario.getRole().getRole();
        this.telefone = usuario.getTelefone();
        this.empresaId = usuario.getEmpresa().getId();
    }
}
