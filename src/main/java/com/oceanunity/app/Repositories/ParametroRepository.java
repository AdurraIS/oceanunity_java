package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Parametro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Long> {

    //Busca todos os parametros paginados
    Page<Parametro> findAllPageable(Pageable pageable);

    // Busca um parâmetro por leitura
    @Query("SELECT p FROM Parametro p WHERE :leituraId IN (SELECT leitura.id FROM p.leituras leitura)")
    Parametro findByLeitura(Long leituraId);


    // Busca um parâmetro por poluente
    @Query("SELECT p FROM Parametro p WHERE :poluenteId IN (SELECT poluente.id FROM p.poluentes poluente)")
    Parametro findByPoluente(Long poluenteId);


}
