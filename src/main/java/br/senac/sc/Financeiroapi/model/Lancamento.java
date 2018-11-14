/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.model;

import java.time.LocalDate;

/**
 *
 * @author Alunos
 */
public class Lancamento {
    
    private int id;
    private String descricao;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private double valor;
    private String observacao;
    private TipoLancamento tipoLanc;
    private Categoria categoria;

    public Lancamento() {
    }

    public Lancamento(int id, String descricao, LocalDate dataVencimento, LocalDate dataPagamento, double valor,String observacao, TipoLancamento tipoLanc, Categoria categoria) {
        this.id=id;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.observacao = observacao;
        this.tipoLanc = tipoLanc;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoLancamento getTipoLanc() {
        return tipoLanc;
    }

    public void setTipoLanc(TipoLancamento tipoLanc) {
        this.tipoLanc = tipoLanc;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
