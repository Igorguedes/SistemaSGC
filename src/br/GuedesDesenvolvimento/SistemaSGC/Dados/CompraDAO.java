/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Dados;

import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Igor
 */
public class CompraDAO {

    private static final String SQL_INSERT = "INSERT INTO COMPRA (VALORTOTAL, DATA, CLIENTE,PRODUTO) VALUES ( ?, ?, ?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT CODIGO, VALORTOTAL,DATA,CLIENTE, PTODUTO FROM COMPRA ";

    public void criar(Compra compra) {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);

            comando.setDouble(1, compra.getValorTotal());
            comando.setString(2, compra.getDataFormatadaBanco());
            comando.execute();
            conexao.commit();
            
            

        } catch (Exception e) {
        }

    }

}
