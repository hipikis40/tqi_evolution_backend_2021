package com.clientes.emprestimos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "solicitar_emprestimo")
public class SolicitarEmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long usuario_emp;

    @Column
    @NotNull(message = "Esse campo não pode ser vázio")
    private double valorEmprestimo;

    @Column
    @NotNull(message = "Esse campo não pode ser vázio")
    private Date primeiraParcela;

    @Column
    @NotNull(message = "Esse campo não pode ser vázio")
    private int quantidadeParcelas;

    public SolicitarEmprestimoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUsuario_emp() {
        return usuario_emp;
    }

    public void setUsuario_emp(long usuario_emp) {
        this.usuario_emp = usuario_emp;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public Date getPrimeiraParcela() {
        return primeiraParcela;
    }

    public void setPrimeiraParcela(Date primeiraParcela) {
        this.primeiraParcela = primeiraParcela;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }
}
