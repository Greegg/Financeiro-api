/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.model;

/**
 *
 * @author Alunos
 */
public class Pessoa {
    
    private int id;
    private String nome;
    private boolean ativo;
    private Endereco endereco;
    
    public Pessoa() {
    }

    public Pessoa(int id, String nome, boolean ativo, Endereco endereco) {
        this.id=id;
        this.nome = nome;
        this.ativo = ativo;
        this.endereco= endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
}
