/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Dados;

import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Criptografia;
import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Usuario;
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
public class UsuarioDAO {

    private static final String SQL_INSERT = "INSERT INTO USUARIO    (NOME, CPF ,SENHA ) VALUES (  ?, ?,?)";
    private static final String SQL_SELECT_TODOS = "SELECT CODIGO, NOME,CPF,SENHA FROM USUARIO ";
    private static final String SQL_UPDATE_DADOS = "UPDATE USUARIO SET  NOME = ?, SENHA=? WHERE CPF = ?";
    
     
    public void criar(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);

            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getCPF());
            comando.setString(3, Criptografia.criptografiaSHA(usuario.getSenha()));

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

    public List<Usuario> buscarTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usuario = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                usuario = new Usuario();

                usuario.setCodigo(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setCPF(resultado.getString(3));
                usuario.setSenha(resultado.getString(4));
                usuarios.add(usuario);
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
        return usuarios;
    }

    public void atualizarDados(Usuario usuario) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        
        
         try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE_DADOS);
            
            
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getCPF());
            comando.setString(3, Criptografia.criptografiaSHA(usuario.getSenha()));
            
            comando.setInt(4,usuario.getCodigo());
            
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
    