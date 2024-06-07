package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Alerta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    //Busca todos os alertas paginadas
    Page<Alerta> findAllPageable(Pageable pageable);

    //Busca os Alertas de uma Leitura
    @Query("SELECT u FROM Alerta u WHERE u.leitura.id = :leituraId")
    List<Alerta> findByLeitura(Long leituraId);

}
