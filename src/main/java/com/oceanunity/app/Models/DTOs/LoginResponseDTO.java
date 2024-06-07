package com.oceanunity.app.Models.DTOs;
import com.oceanunity.app.Models.Entities.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {

    private String token;
    private String nomeUsuario;
    private Long id;
    public LoginResponseDTO(String token, Usuario usuario) {
        this.token = token;
        this.nomeUsuario = usuario.getNome();
        this.id = usuario.getId();
    }
}
