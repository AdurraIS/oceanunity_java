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
@Table(name = "tb_leitura")
@NoArgsConstructor
@AllArgsConstructor
public class Leitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_leitura")
    private Long id;
    @Column(name = "valor_leitura")
    private float valor;
    @Column(name = "data_leitura")
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "id_poluente", referencedColumnName = "id_poluente")
    private Poluente poluente;
    @ManyToOne
    @JoinColumn(name = "id_parametro", referencedColumnName = "id_parametro")
    private Parametro parametro;
    @ManyToOne
    @JoinColumn(name = "id_sensor", referencedColumnName = "id_sensor")
    private Sensor sensor;
    @ManyToOne
    @JoinColumn(name = "id_alerta", referencedColumnName = "id_alerta")
    private Alerta alerta;

}
