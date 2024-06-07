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
@Table(name = "tb_parametro")
@NoArgsConstructor
@AllArgsConstructor
public class Parametro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private Long id;
    @Column(name = "nome_parametro")
    private String nome;
    @Column(name = "valor_max_parametro")
    private float maxValor;
    @Column(name = "valor_min_parametro")
    private float minValor;
    @Column(name = "desc_parametro")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametro")
    private Set<Poluente> poluentes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametro")
    private Set<Leitura> leituras;
}
