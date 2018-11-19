/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.model.dao;

import br.senac.sc.Financeiroapi.factory.Dao;
import br.senac.sc.Financeiroapi.interfaces.DaoI;
import br.senac.sc.Financeiroapi.model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hvb
 */
public class PessoaDao extends Dao implements DaoI<Pessoa> {

    @Override
    public boolean salvar(Pessoa obj) {
        sql = "INSERT INTO cliente (nome) VALUES(?)"; // insere os dados recebidos pela interface no banco, nome, data nascimento e cpf
        try {
            stmt = conexao.prepareStatement(this.sql);
            stmt.setString(1, obj.getNome());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizar(Pessoa obj) {
        try {
            stmt = conexao.prepareStatement("UPDATE cliente SET nome=? WHERE id=?");

            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getId());

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
    public boolean excluir(Pessoa obj) {
        try {
            stmt = conexao.prepareStatement("UPDATE cliente SET status = 0 WHERE id = ?");
            stmt.setInt(1, obj.getId());

            return (stmt.executeUpdate() > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Pessoa> listar() {
        try {
            this.sql = "SELECT id, nome FROM pessoa WHERE status = 1 ORDER BY id ASC";
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            List<Pessoa> lista = new ArrayList<>();
            while (res.next()) {
                pessoa = new Pessoa();
                pessoa.setId(res.getInt("id"));
                pessoa.setNome(res.getString("nome"));
                lista.add(pessoa);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Pessoa lerPorId(int id) {
        try {
            stmt = conexao.prepareStatement("SELECT id, nome FROM pessoa"); //seleciona o cliente pelo ID
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            if (res.next()) {
                pessoa.setId(res.getInt("id"));
                pessoa.setNome(res.getString("nome"));
            }
            return pessoa;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Pessoa> pesquisarPorNome(String nome) {
        try {
            stmt = conexao.prepareStatement("SELECT id, nome FROM pessoa WHERE nome LIKE?");
            stmt.setString(1, nome + "%");
            res = stmt.executeQuery();
            List<Pessoa> lista = new ArrayList<>();
            while (res.next()) {
                pessoa.setId(res.getInt("id"));
                pessoa.setNome(res.getString("nome"));
                lista.add(pessoa);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Pessoa> listarTodos() {
        List<Pessoa> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM pessoa");
            res = stmt.executeQuery();
            while (res.next()) {
                pessoa.setId(res.getInt("id"));
                pessoa.setNome(res.getString("nome"));
                lista.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os clientes " + e.getMessage());
        }
        return lista;
    }

}
