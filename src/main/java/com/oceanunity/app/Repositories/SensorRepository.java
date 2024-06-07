package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    //Busca todos os sensores paginados
    Page<Sensor> findAll(Pageable pageable);

    //Busca Sensor de um Poluente e de uma Empresa e retorna Paginado
    @Query("SELECT s FROM Sensor s WHERE s.poluente.id = :poluenteId AND s.empresa.id = :empresaId")
    Page<Sensor> findByPoluenteAndEmpresa(Pageable pageable, Long poluenteId, Long empresaId);

    // Busca Sensores a determinada distancia definida de uma localização
    @Query("SELECT s FROM Sensor s WHERE FUNCTION('ST_DISTANCE', FUNCTION('geography::STGeomFromText', 'POINT(' || s.localizacao.longitude || ' ' || s.localizacao.latitude || ')', 4326), FUNCTION('geography::STGeomFromText', 'POINT(' || :longitude || ' ' || :latitude || ')', 4326)) < :distance")
    Page<Sensor> findByLocation(Pageable pageable, @Param("latitude") double latitude, @Param("longitude") double longitude, @Param("distance") double distance);


    //Busca todos sensores de uma Empresa
    @Query("SELECT u FROM Sensor u WHERE u.empresa.id = :empresaId")
    Page<Sensor> findByEmpresa(Pageable pageable, Long empresaId);

}
