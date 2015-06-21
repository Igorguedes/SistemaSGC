/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Negocio;

import br.GuedesDesenvolvimento.SistemaSGC.Dados.UsuarioDAO;
import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Criptografia;
import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class UsuarioBO {

    public void criar(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Criptografia criptografia = new Criptografia();

        try {

            usuarios = usuarioDAO.buscarTodos();
            Usuario usuarioComparar = new Usuario();
            for (int i = 0; i < usuarios.size(); i++)    
                usuarioComparar = usuarios.get(i);
       
            usuario.setSenha(criptografia.criptografiaSHA(usuario.getSenha()));
                if (!usuario.getNome().equals(usuarioComparar.getNome())) {
                    usuarioDAO.criar(usuario);
                } else if (!usuario.getNome().equals(usuarioComparar.getNome()) && (!usuario.getSenha().equals(usuarioComparar.getSenha()))) {
                    throw new UsuarioSenhaDiferentesException();
                } else {
                    throw new UsuarioExisteException();

                }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Usuario> buscarTodos() throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        return usuarios;

    }

}
