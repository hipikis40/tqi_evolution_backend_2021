package com.clientes.emprestimos.DTO;

import com.clientes.emprestimos.model.SolicitarEmprestimoModel;

import java.util.Date;

public class DetaEmpDTO {

    private long id;
    private double valorEmprestimo;
    private int quantidadeParcelas;
    private Date primeiraParcela;
    private int renda;
    private String email;

    public DetaEmpDTO() {
    }
    public DetaEmpDTO(SolicitarEmprestimoModel model) {
        id = model.getId();
        valorEmprestimo = model.getValorEmprestimo();
        quantidadeParcelas = model.getQuantidadeParcelas();
        primeiraParcela = model.getPrimeiraParcela();
       // renda = usuarioModel.getRenda();
       // email = usuarioModel.getEmail();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public Date getPrimeiraParcela() {
        return primeiraParcela;
    }

    public void setPrimeiraParcela(Date primeiraParcela) {
        this.primeiraParcela = primeiraParcela;
    }

    public int getRenda() {
        return renda;
    }

    public void setRenda(int renda) {
        this.renda = renda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DetaEmpDTO{" +
                "id=" + id +
                ", valorEmprestimo=" + valorEmprestimo +
                ", quantidadeParcelas=" + quantidadeParcelas +
                ", primeiraParcela=" + primeiraParcela +
                ", renda=" + renda +
                ", email='" + email + '\'' +
                '}';
    }
}
