package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.AcoesMitigacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AcoesMitigacaoRepository extends JpaRepository<AcoesMitigacao, Long> {

    //Busca todas Acoes por Empresa
    @Query("SELECT u FROM AcoesMitigacao u WHERE u.empresa.id = :empresaId")
    Page<AcoesMitigacao> findByEmpresa(Pageable pageable, Long empresaId);

    //Busca todas Acoes por Poluente e Empresa
    @Query("SELECT u FROM AcoesMitigacao u WHERE u.empresa.id = :empresaId AND u.poluente.id = :poluenteId")
    Page<AcoesMitigacao> findByPoluenteAndEmpresa(Pageable pageable, Long empresaId, Long poluenteId);

    //Busca todas Acoes por Poluente
    @Query("SELECT u FROM AcoesMitigacao u WHERE u.poluente.id = :poluenteId")
    Page<AcoesMitigacao> findByPoluente(Pageable pageable, Long poluenteId);
}
