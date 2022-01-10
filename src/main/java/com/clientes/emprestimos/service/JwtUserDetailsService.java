package com.clientes.emprestimos.service;

import com.clientes.emprestimos.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> user = usuarioService.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não existe : " + username);
        }
        UsuarioModel usuario = user.get();
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(),
                new ArrayList<>());
    }
}
