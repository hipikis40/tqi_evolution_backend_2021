package com.clientes.emprestimos.controller;

import com.clientes.emprestimos.config.EncrypSenha;
import com.clientes.emprestimos.config.JwtTokenUtil;
import com.clientes.emprestimos.model.JwtResponse;
import com.clientes.emprestimos.model.UsuarioModel;


import com.clientes.emprestimos.service.JwtUserDetailsService;
import com.clientes.emprestimos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EncrypSenha encrypSenha;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UsuarioModel authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getSenha());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping(path = "/usuarios")
    public List<UsuarioModel> listarUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @PostMapping(value = "/salvarusuario")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioModel> criarUsuario(@Valid @RequestBody UsuarioModel usuarioModel){
        usuarioModel.setSenha(encrypSenha.getPasswordEncoder().encode(usuarioModel.getSenha()));
        usuarioService.getSalvarUsuarios(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModel);
    }

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<UsuarioModel> findById(@PathVariable("id") long id){
         return usuarioService.findById(id)
                 .map(record -> ResponseEntity.ok().body(record))
                 .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/usuario/{id}"})
    public ResponseEntity <?> deleteUsuario(@PathVariable long id) {
        return usuarioService.findById(id)
                .map(record -> {
                    usuarioService.deleteUsuario(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/validaSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String email,
                                                @RequestParam String senha){
           Optional<UsuarioModel> modelOptional = usuarioService.findByLogin(email);
           if(modelOptional.isEmpty()){
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
           }
           boolean valid = false;

           UsuarioModel usuarioModel = modelOptional.get();
           UsuarioModel usuario = modelOptional.get();
          // boolean valid = encoder.matches(senha, usuario.getSenha());
           System.out.println(usuarioModel.getSenha());
           HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
           return ResponseEntity.status(status).body(valid);
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
