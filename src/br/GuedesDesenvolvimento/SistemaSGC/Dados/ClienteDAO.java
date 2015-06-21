/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Dados;

import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class ClienteDAO {

    private static final String SQL_INSERT = "INSERT INTO CLIENTE (NOME, TELEFONE, CPF, ENDERECO) VALUES ( ?, ?, ?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT CODIGO, NOME,TELEFONE, CPF, ENDERECO FROM CLIENTE ";

    public void criar(Cliente cliente) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);

            comando.setString(1, cliente.getNome());

            comando.setString(2, cliente.getTelefone());
            comando.setString(3, cliente.getCPF());
            comando.setString(4, cliente.getEndereco());

            comando.execute();

            conexao.commit();
        } catch (Exception e) {

            if (conexao != null) {
                conexao.rollback();
            }

            throw new RuntimeException(e);
        } finally {

            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public List<Cliente> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt(1));
                cliente.setNome(resultado.getString(2));
                cliente.setTelefone(resultado.getString(3));
                cliente.setCPF(resultado.getString(4));
                cliente.setEndereco(resultado.getString(5));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (resultado != null && !resultado.isClosed()) {
                resultado.close();
            }
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return clientes;
    }

    public Cliente buscarCliente() throws SQLException {
        Cliente cliente= new Cliente();
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);

            if (resultado.next()) {

                cliente.setCodigo(resultado.getInt(1));
                cliente.setNome(resultado.getString(2));
                cliente.setTelefone(resultado.getString(3));
                cliente.setCPF(resultado.getString(4));
                cliente.setEndereco(resultado.getString(5));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (resultado != null && !resultado.isClosed()) {
                resultado.close();
            }
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return cliente;
    }

}
