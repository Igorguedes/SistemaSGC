/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.GuedesDesenvolvimento.SistemaSGC.Apresentacao;

import br.GuedesDesenvolvimento.SistemaSGC.Entidade.Usuario;
import br.GuedesDesenvolvimento.SistemaSGC.Negocio.UsuarioBO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Igor
 */
public class TelaExibirUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form TelaExibirUsuarios
     */
    List<Usuario> usuarios;
    public TelaExibirUsuarios() {
        initComponents();
        exibirDadosTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUsuariosCadastrados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários cadastrados");
        setAlwaysOnTop(true);
        setExtendedState(6);

        pnlUsuariosCadastrados.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuários cadastrados"));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "CPF"
            }
        ));
        jScrollPane1.setViewportView(tblUsuarios);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUsuariosCadastradosLayout = new javax.swing.GroupLayout(pnlUsuariosCadastrados);
        pnlUsuariosCadastrados.setLayout(pnlUsuariosCadastradosLayout);
        pnlUsuariosCadastradosLayout.setHorizontalGroup(
            pnlUsuariosCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuariosCadastradosLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addGap(47, 47, 47))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlUsuariosCadastradosLayout.setVerticalGroup(
            pnlUsuariosCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuariosCadastradosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlUsuariosCadastradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUsuariosCadastrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUsuariosCadastrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhaSelecionada = tblUsuarios.getSelectedRow();
        try {
            if (linhaSelecionada < 0) {
                JOptionPane.showMessageDialog(this, "Nenhum usuário selecionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else {
                Usuario usuarioSelecionado=usuarios.get(linhaSelecionada);
                TelaEditarUsuario telaEditarUsuario = new TelaEditarUsuario(usuarioSelecionado);
                telaEditarUsuario.setVisible(true);
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tblUsuarios.getSelectedRow();
        Usuario usuarioSelecionado=usuarios.get(linhaSelecionada);
        String mensagem="Deseja excluir? "+usuarioSelecionado.getNome();
        String titulo="Excluir";
        int resultado= JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_OPTION); 
        if(resultado==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Usuario excluido com sucesso!");
        }else if(resultado==JOptionPane.NO_OPTION){
            
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void exibirDadosTabela(){
        try{
            carregarListaUsuarios();
            ModelosTabelaUsuarios modelosTabelaUsuarios= new ModelosTabelaUsuarios();
            tblUsuarios.setModel(modelosTabelaUsuarios);
            
        }catch(Exception e){
            exibirMensagemErro();
            e.printStackTrace();
        }
        
    
    }
    public void carregarListaUsuarios() throws SQLException{
        UsuarioBO usuariBO= new UsuarioBO();
        this.usuarios=usuariBO.buscarTodos();
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaExibirUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExibirUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExibirUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExibirUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExibirUsuarios().setVisible(true);
            }
        });
    }
    
    private void exibirMensagemErro() {
        String titulo = "Erro ao carregar usuários!";
        String mensagem = "Erro desconhecido. Consulte o administrador do sistema!";
        JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlUsuariosCadastrados;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
 class ModelosTabelaUsuarios extends AbstractTableModel {

        @Override
        public String getColumnName(int Column) {
            if (Column == 0) {
                return "Codigo";
            } else if (Column == 1) {
                return "Nome";
            } else {
                return "CPF";
            } 
            
        }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Usuario usuario= usuarios.get(linha);
        if (coluna == 0) {
            return usuario.getCodigo();
        } else if (coluna == 1) {
            return usuario.getNome();
        } else {
            return usuario.getCPF();
        } 
    }

}




}
