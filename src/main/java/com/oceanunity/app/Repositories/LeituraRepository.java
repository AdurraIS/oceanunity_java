package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Leitura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LeituraRepository extends JpaRepository<Leitura, Long> {

    //Busca todas as leituras paginadas
    Page<Leitura> findAll(Pageable pageable);


    //Busca todas as Leituras feitas de um Poluente e retorna Paginado
    @Query("SELECT u FROM Leitura u WHERE u.poluente.id = :poluenteId")
    Page<Leitura> findByPoluente(Pageable pageable, Long poluenteId);

    //Busca todas as Leituras feitas de um Sensor e retorna Paginado
    @Query("SELECT u FROM Leitura u WHERE u.sensor.id = :sensorId")
    Page<Leitura> findBySensor(Pageable pageable, Long sensorId);

    //Busca todas as Leituras feitas de um tipo de Parametro e retorna Paginado
    @Query("SELECT u FROM Leitura u WHERE u.parametro.id = :parametroId")
    Page<Leitura> findByParametro(Pageable pageable, Long parametroId);
}
