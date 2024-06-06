package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    //Busca os Alertas de uma Leitura
    @Query("SELECT u FROM Alerta u WHERE u.leitura.id = :leituraId")
    List<Alerta> findByLeitura(Long leituraId);

}
