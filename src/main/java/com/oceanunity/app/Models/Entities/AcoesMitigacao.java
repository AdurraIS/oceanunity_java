package com.oceanunity.app.Models.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_acoes_mitigacao")
@NoArgsConstructor
@AllArgsConstructor
public class AcoesMitigacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acao")
    private Long id;
    @Column(name = "nome_acao")
    private String nome;
    @Column(name = "desc_acao")
    private String descricao;
    @Column(name = "data_inicio_acao")
    private LocalDateTime dataInicio;
    @Column(name = "data_fim_acao")
    private LocalDateTime dataFim;
    @Column(name = "status_acao")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "id_poluente", referencedColumnName = "id_poluente")
    private Poluente poluente;

}
