/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Dados;

import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Produto;
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
public class ProdutoDAO {

    private static final String SQL_INSERT = "INSERT INTO PRODUTO (NOME, PRECO, QUANTIDADE) VALUES ( ?, ?, ?)";
    private static final String SQL_SELECT_TODOS = "SELECT CODIGO, NOME, PRECO, QUANTIDADE FROM PRODUTO ";
    private static final String SQL_RECUPERA_CODIGO = "SELECT MAX(CODIGO) FROM PRODUTO";

    public void criar(Produto produto) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado= null;
        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);
            

            comando.setString(1, produto.getNome());
            comando.setDouble(2, produto.getPreco());
            comando.setInt(3, produto.getQuantidade());
            
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

    public List<Produto> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Produto> produtos = new ArrayList<Produto>();

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Produto produto = new Produto();
                produto.setNome(resultado.getString(2));
                produto.setPreco(resultado.getDouble(3));
                produto.setQuantidade(resultado.getInt(4));

                produtos.add(produto);
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
        return produtos;
    }

}
