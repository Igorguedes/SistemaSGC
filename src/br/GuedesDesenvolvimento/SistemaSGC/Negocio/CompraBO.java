/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Negocio;

import br.GuedesDesenvolvimento.SistemaSGC.Dados.CompraDAO;
import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Compra;
import br.GuedesDesenvolvimento.SistemaSGC.Negocio.Exception.ClienteInexistenteException;
import br.GuedesDesenvolvimento.SistemaSGC.Negocio.Exception.CompraValorNegativoException;
import br.GuedesDesenvolvimento.SistemaSGC.Negocio.Exception.ProdutoInexistenteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class CompraBO {

    public void criar(Compra compra) throws SQLException {

        CompraDAO compraDAO = new CompraDAO();

        try {
            compraDAO.criar(compra);
            if (compra.getCliente() == null) {
                throw new ClienteInexistenteException();
            } else if (compra.getProdutos().isEmpty()) {
                throw new ProdutoInexistenteException();
            } else if (compra.getValorTotal() < 0) {
                throw new CompraValorNegativoException();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Compra> buscarTodos() throws SQLException {
        CompraDAO compraDAO = new CompraDAO();
        List<Compra> compras = new ArrayList<Compra>();

        compras = compraDAO.buscarCompras();
        return compras;
    }

}
