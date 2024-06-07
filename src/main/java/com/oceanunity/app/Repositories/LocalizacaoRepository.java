package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Localizacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
    //Busca todas as localizações paginadas
    Page<Localizacao> findAllPageable(Pageable pageable);
}
