package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Poluente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PoluenteRepository extends JpaRepository<Poluente,Long> {


    //Busca todos os poluentes paginados
    Page<Poluente> findAll(Pageable pageable);
    //Busca Poluentes por Parametros
    @Query("SELECT u FROM Poluente u WHERE u.parametro.id = :parametroId")
    Page<Poluente> findByParametro(Pageable pageable, Long parametroId);

}
