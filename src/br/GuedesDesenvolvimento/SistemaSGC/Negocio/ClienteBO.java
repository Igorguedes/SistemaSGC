/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Negocio;

import br.GuedesDesenvolvimento.SistemaSGC.Dados.ClienteDAO;
import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Igor
 */
public class ClienteBO {

    public void novoCliente(Cliente cliente) {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.criar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<Cliente> buscarTodos() throws SQLException{
        ClienteDAO clienteDAO= new ClienteDAO();
        List<Cliente> clientes=clienteDAO.buscarTodos();
        return clientes;
    
    }
    
     public void atualizarDados(Cliente cliente) throws SQLException{
      ClienteDAO clienteDAO = new ClienteDAO();  
      clienteDAO.atualizarDados(cliente);
    }
}
