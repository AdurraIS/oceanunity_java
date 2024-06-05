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
@Table(name = "tb_sensor")
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sensor")
    private Long id;
    @Column(name = "modelo_sensor")
    private String modelo;
    @Column(name = "status_sensor")
    private String status;
    @Column(name = "fabricante_sensor")
    private String fabricante;
    @Column(name = "data_instalacao_sensor")
    private LocalDateTime data;

    @ManyToOne
    private Poluente poluente;
    @ManyToOne
    private Localizacao localizacao;
    @ManyToOne
    private Empresa empresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensor")
    private Set<Leitura> leituras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensor")
    private Set<Manutencao> manutencoes;
}
