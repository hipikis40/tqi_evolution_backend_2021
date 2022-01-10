package com.clientes.emprestimos.DTO;

import com.clientes.emprestimos.model.SolicitarEmprestimoModel;

public class EmpDTO {

    private long id;
    private double valorEmprestimo;
    private int quantidadeParcelas;

    public EmpDTO() {
    }
    public EmpDTO(SolicitarEmprestimoModel model) {
        id = model.getId();
        valorEmprestimo = model.getValorEmprestimo();
        quantidadeParcelas = model.getQuantidadeParcelas();
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

    @Override
    public String toString() {
        return "EmpDTO{" +
                "id=" + id +
                ", valorEmprestimo=" + valorEmprestimo +
                ", quantidadeParcelas=" + quantidadeParcelas +
                '}';
    }
}
