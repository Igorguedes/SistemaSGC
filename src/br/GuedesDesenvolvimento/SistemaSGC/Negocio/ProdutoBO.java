/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Negocio;

import br.GuedesDesenvolvimento.SistemaSGC.Dados.ProdutoDAO;
import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Produto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Igor
 */
public class ProdutoBO {

    public void novoProduto(Produto produto) throws SQLException {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.criar(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Produto> buscarProdutos() throws SQLException{
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos= produtoDAO.buscarTodos();
        return produtos;
    
    }
    
    public void atualizarDadosProduto(Produto produto) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.atualizarDados(produto);
    }
}
