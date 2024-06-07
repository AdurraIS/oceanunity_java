package com.oceanunity.app.Models.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Set<Usuario> usuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Set<AcoesMitigacao> acoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Set<Sensor> sensores;

}
