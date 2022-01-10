package com.clientes.emprestimos.DTO;

import com.clientes.emprestimos.model.UsuarioModel;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

     UsuarioDTO usarioDTO(UsuarioModel usuarioModel);

     UsuarioModel model(UsuarioDTO usuarioDTO);
}
