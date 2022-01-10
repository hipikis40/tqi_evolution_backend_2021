package com.clientes.emprestimos.repository;

import com.clientes.emprestimos.DTO.UsuarioDTO;
import com.clientes.emprestimos.model.SolicitarEmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmprestimoRepository extends JpaRepository<SolicitarEmprestimoModel, Long> {

    @Query(value = "SELECT * FROM solicitar_emprestimo WHERE usuario_emp = ?", nativeQuery = true)
    List<SolicitarEmprestimoModel> findByChave(long emp);

}
