package com.clientes.emprestimos.service;

import com.clientes.emprestimos.DTO.DetaEmpDTO;
import com.clientes.emprestimos.DTO.UsuarioDTO;
import com.clientes.emprestimos.model.SolicitarEmprestimoModel;
import com.clientes.emprestimos.model.UsuarioModel;
import com.clientes.emprestimos.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImp implements EmprestimoService {

    @Autowired
    public EmprestimoRepository emRepository;

    @Override
    public SolicitarEmprestimoModel getSalvarEmprestimos(SolicitarEmprestimoModel model) {
        return emRepository.save(model);
    }

    @Override
    public List<SolicitarEmprestimoModel> getAllEmprestimo() {
        return emRepository.findAll();
    }

    @Override
    public List<SolicitarEmprestimoModel> findByChave(long emp) {
        return emRepository.findByChave(emp);
    }

    @Override
    public Optional<SolicitarEmprestimoModel> findById(long id) {
        return emRepository.findById(id);
    }
}
