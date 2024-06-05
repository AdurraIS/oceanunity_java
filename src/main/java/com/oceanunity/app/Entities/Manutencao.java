package com.oceanunity.app.Entities;

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

}
