/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.model.dao;

import br.senac.sc.Financeiroapi.factory.Dao;
import br.senac.sc.Financeiroapi.interfaces.DaoI;
import br.senac.sc.Financeiroapi.model.Lancamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LancamentoDao extends Dao implements DaoI<Lancamento> {

    @Override
    public boolean salvar(Lancamento obj) {
        sql = "INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES(?,?,?,?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(this.sql);
            stmt.setString(1, obj.getDescricao());
//            stmt.setData(2, obj.getDataVencimento());
//            stmt.setDate(3, obj.getDataPagamento());
            stmt.setDouble(4, obj.getValor());
            stmt.setString(5, obj.getObservacao());
            stmt.setInt(6, obj.getTipoLanc().getValor());
            stmt.setLong(7, obj.getCategoria().getId());
            stmt.setLong(8, obj.getPessoa().getId());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizar(Lancamento obj) {
        try {
            stmt = conexao.prepareStatement("UPDATE lancamento SET descricao=?, data_vencimento=?, data_pagamento=?, valor=?, observacao=?, tipo=?, codigo_categoria=?, "
                    + "codigo_pessoa=? WHERE id=?");
            stmt.setString(1, obj.getDescricao());
//            stmt.setData(2, obj.getDataVencimento());
//            stmt.setDate(3, obj.getDataPagamento());
            stmt.setDouble(4, obj.getValor());
            stmt.setString(5, obj.getObservacao());
            stmt.setInt(6, obj.getTipoLanc().getValor());
            stmt.setLong(7, obj.getCategoria().getId());
            stmt.setLong(8, obj.getPessoa().getId());
            stmt.setInt(9, obj.getId());

            if (stmt.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean excluir(Lancamento obj) {
        try {
            stmt = conexao.prepareStatement("UPDATE lancamento SET status = 0 WHERE id = ?");
            stmt.setInt(1, obj.getId());
            return (stmt.executeUpdate() > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Lancamento> listar() {
        try {
            this.sql = "SELECT descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa WHERE status = 1 ORDER BY id ASC";
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();

            List<Lancamento> lista = new ArrayList<>();
            while (res.next()) {
                lancamento = new Lancamento();
                lancamento.setId(res.getInt("id"));
                lancamento.setDescricao(res.getString("descricao"));
//                lancamento.setDataVencimento(res.getDate("data_vencimento"));
//                lancamento.setDataPagamento(res.getDate("data_pagamento"));
                lancamento.setValor(res.getLong("valor"));
                lancamento.setObservacao(res.getString("observacao"));
                lancamento.setTipoLanc(res.getInt());
                lancamento.setCategoria(res.getString("descricao"));
                lancamento.setres.getString("descricao"));

                lista.add(categoria);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
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
