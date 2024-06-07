package com.oceanunity.app.Models.DTOs;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthenticationDTO {
    @NotBlank(message = "Campo email não pode ser vazio")
    private String email;
    @NotBlank(message = "Campo senha não pode ser vazio")
    private String senha;

}