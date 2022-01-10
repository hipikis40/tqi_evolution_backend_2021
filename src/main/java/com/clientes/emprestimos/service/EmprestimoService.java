package com.clientes.emprestimos.service;

import com.clientes.emprestimos.DTO.DetaEmpDTO;
import com.clientes.emprestimos.DTO.UsuarioDTO;
import com.clientes.emprestimos.model.SolicitarEmprestimoModel;
import com.clientes.emprestimos.model.UsuarioModel;

import java.util.List;
import java.util.Optional;

public interface EmprestimoService {

    SolicitarEmprestimoModel getSalvarEmprestimos(SolicitarEmprestimoModel model);
    List<SolicitarEmprestimoModel> getAllEmprestimo();
    List<SolicitarEmprestimoModel> findByChave(long emp);
    Optional<SolicitarEmprestimoModel> findById(long id);

}
