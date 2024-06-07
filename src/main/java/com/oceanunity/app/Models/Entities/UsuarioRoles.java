package com.oceanunity.app.Models.Entities;
public enum UsuarioRoles {

    ADMIN("admin"),
    USER("user");



    private String role;

    UsuarioRoles(String role){
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
