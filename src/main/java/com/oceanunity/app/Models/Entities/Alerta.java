package com.oceanunity.app.Models.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tb_alerta")
@NoArgsConstructor
@AllArgsConstructor
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long id;
    @Column(name = "tipo_alerta")
    private String tipo;
    @Column(name = "desc_alerta")
    private String descricao;
    @Column(name = "data_alerta")
    private LocalDateTime data;
    @Column(name = "resolucao_alerta")
    private String resolucao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alerta")
    private Set<Leitura> leituras;

}
