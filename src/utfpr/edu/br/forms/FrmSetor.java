/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.forms;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utfpr.edu.br.conexao.TransactionUtil;
import utfpr.edu.br.dao.DaoSetor;
import utfpr.edu.br.model.Setor;

import utfpr.edu.br.util.Util;
/**
 *
 * @author magno
 */
public class FrmSetor extends javax.swing.JFrame {

    /**
     * Creates new form FrmSetor
     */
    private DefaultTableModel model;
    private String dadosSetor[] = new String[]{"id","descricao"};
    private List<Setor> setor;
    
    public FrmSetor() {
        initComponents();
        iniciarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSetor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Setor");

        tbSetor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSetorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSetor);

        jLabel1.setText("ID");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar por Descrição");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Inserir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAlterar.setText("Atualizar selecionado");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        obterPorDescricao();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        remover();
        txtId.setEditable(true);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        atualizar();
        txtId.setEditable(true);
       
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tbSetorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSetorMouseClicked
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_tbSetorMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        novo();
        txtId.setEditable(true);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSetor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSetor;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    private void preenchertabela()
    {
        model = new DefaultTableModel();

        model.setColumnIdentifiers(dadosSetor);


        if (setor != null || setor.isEmpty()) {
            for (Setor s : setor) {
                model.addRow(new Object[]{
                    
                    s.getId(),
                    s.getDescricao()
                });
            }
            tbSetor.setModel(model);
        } else {
            model = new DefaultTableModel();
            model.setColumnIdentifiers(dadosSetor);
            tbSetor.setModel(model);
        }
    }
     private void iniciarTabela() {
        setor = new DaoSetor().listar();
        if (setor != null) {
            preenchertabela();
        }
    }
    private void obterPorDescricao() 
    {
        try {
            setor.clear();
            setor = new DaoSetor().obterNome(txtDescricao.getText());
            preenchertabela();
        } catch (Exception e) {
            Logger.getLogger(FrmSetor.class.getName()).log(Level.SEVERE, null, e);//erro
            Util.dispayMsg("Erro ao Pesquisar Por Descrição!");

        }
    }
    private void insert()
    {
        Setor s = new Setor();
        if (!txtId.getText().isEmpty()) 
        {  //verifica se o campo Codigo esta vazio
                s.setId(Integer.parseInt(txtId.getText()));
        }
        
        s.setDescricao(txtDescricao.getText().trim());
        
        TransactionUtil.beginTransaction();
            try {
                new DaoSetor().persistir(s);
                TransactionUtil.commit();
            } catch (Exception ex) {
                TransactionUtil.rollback();
                Logger.getLogger(FrmSetor.class.getName()).log(Level.SEVERE, null, ex);//erro
            }
            
        novo();  
    }
    void novo()
    {
        txtId.setText(null);
        txtDescricao.setText(null);
        iniciarTabela();

    }
    private void remover() {
        if (!txtId.getText().isEmpty()) {
            int id = Integer.parseInt(txtId.getText().trim());
            try {
                TransactionUtil.beginTransaction();
                DaoSetor dao = new DaoSetor();
                dao.remover(dao.obterPorId(id));
                TransactionUtil.commit();
            } catch (Exception e) {
                TransactionUtil.rollback();
                Util.dispayMsg("erro Inesperado!");
                Logger.getLogger(FrmSetor.class.getName()).log(Level.SEVERE, null, e);//erro
            }
            novo();
        } 
        else 
        {
            JOptionPane.showMessageDialog(rootPane, "Nenhum registro selecionando !");
        }
    }
     void editar()
     {
         int selecionada = tbSetor.getSelectedRow();
        if (selecionada == -1){
            JOptionPane.showMessageDialog(null, "Nenhum selecionado, Selecione uma linha da tabela", "Mensagem", JOptionPane.ERROR_MESSAGE, null);
        }else{
            txtId.setText(tbSetor.getValueAt(selecionada, 0).toString());
            txtId.setEditable(false);
            txtDescricao.setText(tbSetor.getValueAt(selecionada, 1).toString());
            
        }
     }
     void atualizar()
     {
        Setor s = new Setor();
        if (!txtId.getText().isEmpty()) 
        {  //verifica se o campo Codigo esta vazio
                s.setId(Integer.parseInt(txtId.getText()));
        }
        
        s.setDescricao(txtDescricao.getText().trim());
        
        TransactionUtil.beginTransaction();
            try {
                new DaoSetor().atualizar(s);
                TransactionUtil.commit();
            } catch (Exception ex) {
                TransactionUtil.rollback();
                Logger.getLogger(FrmSetor.class.getName()).log(Level.SEVERE, null, ex);//erro
            }
            
        novo();  
                    txtId.setEditable(true);

     }
}

