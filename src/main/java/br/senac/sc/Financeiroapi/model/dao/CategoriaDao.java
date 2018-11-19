/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.model.dao;

import br.senac.sc.Financeiroapi.factory.Dao;
import br.senac.sc.Financeiroapi.interfaces.DaoI;
import br.senac.sc.Financeiroapi.model.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hvb
 */
public class CategoriaDao extends Dao implements DaoI<Categoria> {

    @Override
    public boolean salvar(Categoria obj) {
        sql = "INSERT INTO categoria (nome) VALUES(?)";
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
    public boolean atualizar(Categoria obj) {
        try {
            stmt = conexao.prepareStatement("UPDATE categoria SET nome=? WHERE id=?");

            stmt.setString(1, obj.getNome());

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
    public boolean excluir(Categoria obj) {
        try {
            stmt = conexao.prepareStatement("UPDATE categoria SET status = 0 WHERE id = ?");
            stmt.setLong(1, obj.getId());
            return (stmt.executeUpdate() > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Categoria> listar() {
        try {
            this.sql = "SELECT id, nome FROM categoria WHERE status = 1 ORDER BY id ASC";
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();

            List<Categoria> lista = new ArrayList<>();
            while (res.next()) {
                categoria = new Categoria();
                categoria.setId(res.getLong("id"));
                categoria.setNome(res.getString("nome"));

                lista.add(categoria);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Categoria lerPorId(int id) {
        try {
            stmt = conexao.prepareStatement("SELECT id,nome FROM endereco WHERE id=?");
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            if (res.next()) {
                categoria.setId(res.getLong("id"));
                categoria.setNome(res.getString("nome"));
            }
            return categoria;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria> pesquisarPorNome(String nome) {
        try {
            stmt = conexao.prepareStatement("SELECT id, nome FROM categoria WHERE nome LIKE?");
            stmt.setString(1, nome + "%");
            res = stmt.executeQuery();
            
            List<Categoria> lista = new ArrayList<>();
            while (res.next()) {
                categoria.setId(res.getLong("id"));
                categoria.setNome(res.getString("nome"));
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria> listarTodos() {
        List<Categoria> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM categoria");
            res = stmt.executeQuery();
            while (res.next()) {
                categoria.setId(res.getLong("id"));
                categoria.setNome(res.getString("nome"));
                lista.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar todas as categorias " + e.getMessage());
        }
        return lista;
    }
}
