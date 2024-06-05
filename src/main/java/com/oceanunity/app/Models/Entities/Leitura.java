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
    private Poluente poluente;
    @ManyToOne
    private Parametro parametro;
    @ManyToOne
    private Sensor sensor;
    @ManyToOne
    private Alerta alerta;

}
