package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    //Busca todas as empresas paginadas
    Page<Empresa> findAllPageable(Pageable pageable);

    // Busca todoas as Empresas pelo nome
    @Query("SELECT u FROM Empresa u WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Page<Empresa> findByNomeLike(Pageable pageable, String nome);

    // Busca todoas as Empresas pelo UF
    @Query("SELECT u FROM Empresa u WHERE LOWER(u.uf) LIKE LOWER(CONCAT('%', :uf, '%'))")
    Page<Empresa> findByUFLike(Pageable pageable, String uf);
}

