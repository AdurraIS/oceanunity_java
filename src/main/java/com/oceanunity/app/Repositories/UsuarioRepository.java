package com.oceanunity.app.Repositories;

import com.oceanunity.app.Models.Entities.Poluente;
import com.oceanunity.app.Models.Entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Busca usuario por nome ou telefone
    Usuario findByNomeOrTelefone(String nome, String telefone);

    //Busca todos Usuarios de uma Empresa
    @Query("SELECT u FROM Usuario u WHERE u.empresa.id = :empresaId")
    Set<Usuario> findByEmpresa(Long empresaId);

    // Busca todos os usuários de uma empresa pelo nome
    @Query("SELECT u FROM Usuario u WHERE u.empresa.id = :empresaId AND LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Page<Usuario> findByEmpresaAndNomeLike(Pageable pageable, Long empresaId, String nome);

    //Busca usuario por email e retorna um UserDetails
    UserDetails findByEmail(String email);

    //Busca usuario por email e retorna um Usuario
    Usuario findUsuarioByEmail(String email);

}
