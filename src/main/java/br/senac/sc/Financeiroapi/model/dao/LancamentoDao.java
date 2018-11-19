/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.model.dao;

import br.senac.sc.Financeiroapi.factory.Dao;
import br.senac.sc.Financeiroapi.interfaces.DaoI;
import br.senac.sc.Financeiroapi.model.Lancamento;
import java.util.List;

public class LancamentoDao extends Dao implements DaoI<Lancamento>{

    @Override
    public boolean salvar(Lancamento obj) {
        sql = "INSERT INTO lancamento (nome) VALUES(?)";
        try {
            stmt = conexao.prepareStatement(this.sql);
            stmt.setString(1, obj.getDescricao());
            stmt.set(1, obj.getDataVencimento());
            stmt.setString(1, obj.getNome());
            stmt.setString(1, obj.getNome());
            stmt.setString(1, obj.getNome());
            stmt.setString(1, obj.getNome());
            stmt.setString(1, obj.getNome());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizar(Lancamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Lancamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lancamento> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lancamento lerPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lancamento> pesquisarPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lancamento> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
