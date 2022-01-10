package com.clientes.emprestimos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "clientes")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotEmpty(message = "Esse campo não pode ser vázio")
    private String nome;

    @Column(unique = true)
    @Email
    private String email;

    @Column(unique = true)
    @NotNull
    @NotBlank
    @NotEmpty(message = "Esse campo não pode ser vazio")
    @Size(min = 11, max = 11 , message = "O cpf tem que conter 11 números.")
    private String cpf;

    @Column
    @NotNull
    //@NotEmpty(message = "Esse campo não pode ser vázio")
    private long rg;

    @Column
    @NotNull
   // @NotEmpty(message = "Esse campo não pode ser vázio")
    private int renda;

    @Column
    @NotEmpty(message = "Esse campo não pode ser vázio")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @NotNull
    @Size(min = 2, max = 60)
    private String logradouro;

    @NotNull
    @Size(min = 1, max = 5)
    private String numero;

    //@Size(min = 1, max = 10)
    private String complemento;

    @NotNull
    @Size(min = 3, max = 50)
    private String bairro;

    @NotNull
    @Size(min = 4, max = 9)
    private String cep;

    @NotNull
    @Size(min = 2, max = 30)
    private String cidade;

    @NotNull
    @Size(min = 2, max = 2)
    private String estado;

    public UsuarioModel() {
    }

    public UsuarioModel(String email) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public int getRenda() {
        return renda;
    }

    public void setRenda(int renda) {
        this.renda = renda;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
