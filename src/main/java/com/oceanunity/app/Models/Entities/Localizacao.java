package com.oceanunity.app.Models.Entities;

import com.oceanunity.app.Models.DTOs.LocalizacaoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tb_localizacao")
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long id;
    @Column(name = "latitude_local")
    private int latitude;
    @Column(name = "longitude_local")
    private int longitude;
    @Column(name = "descricao_local")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localizacao")
    private Set<Sensor> sensors;

    public Localizacao(LocalizacaoDTO localizacao) {
        this.id = localizacao.getId();
        this.descricao = localizacao.getDescricao();
        this.longitude = localizacao.getLongitude();
        this.latitude = localizacao.getLatitude();
    }

}
