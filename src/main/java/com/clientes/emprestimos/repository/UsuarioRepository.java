package com.clientes.emprestimos.repository;

import com.clientes.emprestimos.model.SolicitarEmprestimoModel;
import com.clientes.emprestimos.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query(value = "SELECT * FROM clientes WHERE email = ?", nativeQuery = true)
    Optional<UsuarioModel> findByLogin(String email);
}

