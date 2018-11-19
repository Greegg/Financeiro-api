/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.factory;

import br.senac.sc.Financeiroapi.model.Categoria;
import br.senac.sc.Financeiroapi.model.Endereco;
import br.senac.sc.Financeiroapi.model.Lancamento;
import br.senac.sc.Financeiroapi.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alunos
 */
public class Dao {
    protected Connection conexao;
    protected PreparedStatement stmt;
    protected String sql = "";
    protected ResultSet res;
    protected boolean debug = true;
    protected static final String DATABASE_NAME = "financeiro";
    
    protected Pessoa pessoa;
    protected Categoria categoria;
    protected Lancamento lancamento;
    protected Endereco endereco;
    
    
    public Dao(){
        conexao =  Conexao.getConexao();
        openOrCreateDatabase();
    }
    
    private void openOrCreateDatabase(){
        try {
            stmt =  conexao.prepareStatement("CREATE DATABASE IF NOT EXISTS "+DATABASE_NAME); //se o banco não existir, criar 
            stmt.execute();//executar o query
            
            stmt = conexao.prepareStatement("USE "+DATABASE_NAME); //usar o bando "loja"
            stmt.execute();//executar o query
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
}
