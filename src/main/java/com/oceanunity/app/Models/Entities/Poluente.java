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
@Table(name = "tb_poluente")
@NoArgsConstructor
@AllArgsConstructor
public class Poluente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poluente")
    private Long id;
    @Column(name = "nome_poluente")
    private String nome;
    @Column(name = "desc_poluente")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poluente")
    private Set<AcoesMitigacao> acoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poluente")
    private Set<Leitura> leiturasSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poluente")
    private Set<Sensor> sensores;
    @ManyToOne
    @JoinColumn(name = "id_parametro", referencedColumnName = "id_parametro")
    private Parametro parametro;
}
