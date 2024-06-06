package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Manutencao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    //Busca todas Manutenções de uma Empresa
    @Query("SELECT u FROM Manutencao u WHERE u.empresa.id = :empresaId")
    Page<Manutencao> findByEmpresa(Pageable pageable, Long empresaId);

    //Busca todas Manutenções de um Sensor
    @Query("SELECT u FROM Manutencao u WHERE u.sensor.id = :sensorId")
    Page<Manutencao> findBySensor(Pageable pageable, Long sensorId);
}
