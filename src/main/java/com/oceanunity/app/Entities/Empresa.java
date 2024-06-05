package com.oceanunity.app.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_empresa")
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;
    @Column(name = "nome_empresa")
    private String nome;
    @Column(name = "email_empresa")
    private String email;
    @Column(name = "uf_empresa")
    private String uf;
    @Column(name = "tel_empresa")
    private String telefone;

}
