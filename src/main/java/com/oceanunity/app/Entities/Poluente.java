package com.oceanunity.app.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
