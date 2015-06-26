/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Negocio;

import br.GuedesDesenvolvimento.SistemaSGC.Dados.UsuarioDAO;
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

    }

    public List<Usuario> buscarTodos() throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        return usuarios;

    }

    public Usuario verificaUsuarioLogin(Usuario usuario) throws SQLException, ArgumentInvalidExeception {
        Usuario usuarioExistente = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioExistente = usuarioDAO.buscarLogin(usuario.getNome(), usuario.getSenha());
        if (usuarioExistente != null) {
            return usuarioExistente;
        } else {
            throw new RuntimeException();
        }

    }

    public void atualizarDados(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.atualizarDados(usuario);
    }

}
