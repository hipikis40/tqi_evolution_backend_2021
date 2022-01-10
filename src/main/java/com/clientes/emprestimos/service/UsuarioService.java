package com.clientes.emprestimos.service;

import com.clientes.emprestimos.model.UsuarioModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioModel> getAllUsuarios();
    UsuarioModel getSalvarUsuarios(UsuarioModel model);
    Optional<UsuarioModel> findById(long id);
    void deleteUsuario(long id);

    Optional<UsuarioModel> findByLogin(String email);


}
