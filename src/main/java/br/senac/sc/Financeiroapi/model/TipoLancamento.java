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
public enum TipoLancamento {
    
    
    RECEITA(1),
    DESPESA(2);
    
    private int valor;
    TipoLancamento(int opcaoLancamento){
        valor = opcaoLancamento;
    }
    public int getValor(){
        return valor;
    }
}
