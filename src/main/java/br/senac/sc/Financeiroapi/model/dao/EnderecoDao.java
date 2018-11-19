/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.model.dao;

import br.senac.sc.Financeiroapi.factory.Dao;
import br.senac.sc.Financeiroapi.interfaces.DaoI;
import br.senac.sc.Financeiroapi.model.Endereco;
import br.senac.sc.Financeiroapi.model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hvb
 */
public class EnderecoDao extends Dao implements DaoI<Endereco>{

    @Override
    public boolean salvar(Endereco obj) {
         sql = "INSERT INTO endereco (logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES(?,?,?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(this.sql);
            stmt.setString(1, obj.getLogradouro());
            stmt.setString(2, obj.getNumero());
            stmt.setString(3, obj.getComplemento());
            stmt.setString(4, obj.getBairro());
            stmt.setString(5, obj.getCep());
            stmt.setString(6, obj.getCidade());
            stmt.setString(7, obj.getEstado());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizar(Endereco obj) {
        try {
            stmt = conexao.prepareStatement("UPDATE endereco SET logradouro=?, numero=?, complemento=?, bairro=?, cep=?, cidade=?, estado=? WHERE id=?");

            stmt.setString(1, obj.getLogradouro());
            stmt.setString(2, obj.getNumero());
            stmt.setString(3, obj.getComplemento());
            stmt.setString(4, obj.getBairro());
            stmt.setString(5, obj.getCep());
            stmt.setString(6, obj.getCidade());
            stmt.setString(7, obj.getEstado());
            stmt.setInt(8, obj.getId());

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
    public boolean excluir(Endereco obj) {
        try {
            stmt = conexao.prepareStatement("UPDATE endereco SET status = 0 WHERE id = ?");
            stmt.setInt(1, obj.getId());
            return (stmt.executeUpdate() > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Endereco> listar() {
        try {
            this.sql = "SELECT id, logradouro, numero, complemento, bairro, cep, cidade, estado FROM endereco WHERE status = 1 ORDER BY id ASC";
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            List<Endereco> lista = new ArrayList<>();
            while (res.next()) {
                endereco = new Endereco();
                endereco.setId(res.getInt("id"));
                endereco.setLogradouro(res.getString("logradouro"));
                endereco.setNumero(res.getString("numero"));
                endereco.setComplemento(res.getString("complemento"));
                endereco.setBairro(res.getString("bairro"));
                endereco.setCep(res.getString("cep"));
                endereco.setCidade(res.getString("cidade"));
                endereco.setEstado(res.getString("estado"));
                lista.add(endereco);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Endereco lerPorId(int id) {
        try {
            stmt = conexao.prepareStatement("SELECT id, logradouro, numero, complemento, bairro, cep, cidade, estado FROM endereco WHERE id=?");
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            if (res.next()) {
                endereco.setId(res.getInt("id"));
                endereco.setLogradouro(res.getString("logradouro"));
                endereco.setNumero(res.getString("numero"));
                endereco.setComplemento(res.getString("complemento"));
                endereco.setBairro(res.getString("bairro"));
                endereco.setCep(res.getString("cep"));
                endereco.setCidade(res.getString("cidade"));
                endereco.setEstado(res.getString("estado"));
            }
            return endereco;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Endereco> pesquisarPorNome(String nome) {
        try {
            stmt = conexao.prepareStatement("SELECT id, logradouro, numero, complemento, bairro, cep, cidade, estado FROM endereco WHERE bairro LIKE?");
            stmt.setString(1, nome + "%");
            res = stmt.executeQuery();
            List<Endereco> lista = new ArrayList<>();
            while (res.next()) {
                endereco.setId(res.getInt("id"));
                endereco.setLogradouro(res.getString("logradouro"));
                endereco.setNumero(res.getString("numero"));
                endereco.setComplemento(res.getString("complemento"));
                endereco.setBairro(res.getString("bairro"));
                endereco.setCep(res.getString("cep"));
                endereco.setCidade(res.getString("cidade"));
                endereco.setEstado(res.getString("estado"));
                lista.add(endereco);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Endereco> listarTodos() {
        List<Endereco> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement("SELECT * FROM endereco");
            res = stmt.executeQuery();
            while (res.next()) {
                endereco.setId(res.getInt("id"));
                endereco.setLogradouro(res.getString("nologradourome"));
                endereco.setNumero(res.getString("numero"));
                endereco.setComplemento(res.getString("complemento"));
                endereco.setBairro(res.getString("bairro"));
                endereco.setCep(res.getString("cep"));
                endereco.setCidade(res.getString("cidade"));
                endereco.setEstado(res.getString("estado"));
                lista.add(endereco);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os endereços " + e.getMessage());
        }
        return lista;
    }
    
}
