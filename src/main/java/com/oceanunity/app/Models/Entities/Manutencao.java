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
@Table(name = "tb_manutencao")
@NoArgsConstructor
@AllArgsConstructor
public class Manutencao {

    @Id
    @GeneratedValue
    @Column(name = "id_manutencao")
    private Long id;
    @Column(name = "desc_manutencao")
    private String descricao;
    @Column(name = "data_manutencao")
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "id_sensor", referencedColumnName = "id_sensor")
    private Sensor sensor;
    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private Empresa empresa;

}
