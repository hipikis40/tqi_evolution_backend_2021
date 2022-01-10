package com.clientes.emprestimos.controller;

import com.clientes.emprestimos.DTO.DetaEmpDTO;
import com.clientes.emprestimos.DTO.EmpDTO;
import com.clientes.emprestimos.model.SolicitarEmprestimoModel;
import com.clientes.emprestimos.model.UsuarioModel;
import com.clientes.emprestimos.service.EmprestimoService;
import com.clientes.emprestimos.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmprestimoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmprestimoService emService;

    @PostMapping(value = "/emprestimo")
    public ResponseEntity<SolicitarEmprestimoModel> solicitarEmprestimo(@Valid @RequestBody SolicitarEmprestimoModel usuarioModel, Authentication authentication){
        Optional<UsuarioModel> modelOptional = usuarioService.findByLogin(authentication.getName());
        UsuarioModel usuarioEmp = modelOptional.get();
        SimpleDateFormat formatador1 = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtual1 = formatador1.format(usuarioModel.getPrimeiraParcela());
        long val = calculaData(dataAtual1);
        usuarioModel.setUsuario_emp(usuarioEmp.getId());
        if (usuarioModel.getQuantidadeParcelas() > 60 || val >= 90){
            return ResponseEntity.notFound().build();
        }

        emService.getSalvarEmprestimos(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModel);
    }

    @GetMapping(path = "/listEmprestimos")
    public ResponseEntity<List<EmpDTO>> listarEmprestimo(@Valid Authentication authentication){
        Optional<UsuarioModel> modelOptional = usuarioService.findByLogin(authentication.getName());
        UsuarioModel usuarioEmp = modelOptional.get();

        List<SolicitarEmprestimoModel> model = emService.findByChave(usuarioEmp.getId());
        List<EmpDTO> modelDTO = model.stream().map(obj -> new EmpDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(modelDTO);
    }

    @GetMapping(path = "/listEmpresDetalhes/{id}")
    public ResponseEntity<List<DetaEmpDTO>> listarEmprestimo(@Valid @PathVariable long id, Authentication authentication){

        Optional<SolicitarEmprestimoModel> modelo = emService.findById(id);

        List<DetaEmpDTO> modelDTO = modelo.stream().map(obj -> new DetaEmpDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(modelDTO);

    }

    public long calculaData(String dataParcela){
        Date data = new Date();

        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtual = formatador.format(data);

        LocalDate d1 = LocalDate.parse(dataAtual, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse(dataParcela , DateTimeFormatter.ISO_LOCAL_DATE);

        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());

        long diffDays = diff.toDays();

        System.out.println("Diffrence between dates is : "+diffDays + "days");

        return diffDays;
    }
}
