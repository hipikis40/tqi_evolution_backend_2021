package com.clientes.emprestimos.service;

import com.clientes.emprestimos.model.UsuarioModel;
import com.clientes.emprestimos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<UsuarioModel> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel getSalvarUsuarios(UsuarioModel model) {
        return usuarioRepository.save(model);
    }

    @Override
    public Optional<UsuarioModel> findById(long id){
        return usuarioRepository.findById(id); }

    @Override
    public void deleteUsuario(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<UsuarioModel> findByLogin(String email) {
        return usuarioRepository.findByLogin(email);

    }


}
