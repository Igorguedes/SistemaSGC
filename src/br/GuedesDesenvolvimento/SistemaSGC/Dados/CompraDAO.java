/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Dados;

import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Compra;
import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class CompraDAO {

    private static final String SQL_INSERT = "INSERT INTO COMPRA (VALORTOTAL, DATA, CLIENTE,PRODUTO) VALUES ( ?, ?, ?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT CODIGO, VALORTOTAL,DATA,CLIENTE, PRODUTO FROM COMPRA ";
    private static final String SQL_UPDATE_DADOS = "UPDATE COMPRA SET  VALORTOTAL =? WHERE CODIGO=?";
    
    public void criar(Compra compra) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);

            comando.setDouble(1, compra.getValorTotal());
            comando.setString(2, compra.getDataFormatadaBanco());
            comando.setString(3, compra.getCliente().getNome());
           
            comando.setString(4, compra.getProdutos().toString());
            

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

    public List<Compra> buscarCompras() throws SQLException {
        List<Compra> compras = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Produto> produtos = new ArrayList<Produto>();
        Compra compra;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                ClienteDAO clienteDAO = new ClienteDAO();

                compra = new Compra();
                compra.setCodigo(resultado.getInt(1));
                compra.setValorTotal(resultado.getDouble(2));
                compra.setData(resultado.getDate(3));

                compra.setCliente(clienteDAO.buscarCliente());
                produtos = produtoDAO.buscarTodos();

                compra.setProdutos(produtos);
                compras.add(compra);

            }

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
        return compras;
    }
    
    public void atualizarDados(Compra compra) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE_DADOS);
            
            comando.setDouble(1, compra.getValorTotal());
              
            comando.setInt(2, compra.getCodigo());
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new RuntimeException();
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

}
