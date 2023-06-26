/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;
import miqueias_fast_food.Funcionario;
/**
 *
 * @author archago
 */
public class TelaFuncionario extends javax.swing.JFrame {
    /**
     * Creates new form TelaAdm
     */
    public TelaFuncionario() {
        initComponents();
        lbBemVindo.setText("Bem-vindo, " + LoginFun.logged.getNome());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTelaFuncionario = new javax.swing.JPanel();
        lbCabecalho = new javax.swing.JLabel();
        bEdição = new javax.swing.JButton();
        bFuncionarios1 = new javax.swing.JButton();
        lbBemVindo = new javax.swing.JLabel();
        bSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlTelaFuncionario.setBackground(new java.awt.Color(244, 244, 244));

        lbCabecalho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cabecalho.png"))); // NOI18N

        bEdição.setText("Edição");
        bEdição.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bEdição.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEdiçãoActionPerformed(evt);
            }
        });

        bFuncionarios1.setText("Funcionários");
        bFuncionarios1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bFuncionarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFuncionarios1ActionPerformed(evt);
            }
        });

        lbBemVindo.setFont(new java.awt.Font("Segoe UI Emoji", 2, 36)); // NOI18N
        lbBemVindo.setText("Bem-vindo, <nome>");

        bSair.setText("Sair");
        bSair.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTelaFuncionarioLayout = new javax.swing.GroupLayout(pnlTelaFuncionario);
        pnlTelaFuncionario.setLayout(pnlTelaFuncionarioLayout);
        pnlTelaFuncionarioLayout.setHorizontalGroup(
            pnlTelaFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaFuncionarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbCabecalho))
            .addGroup(pnlTelaFuncionarioLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(lbBemVindo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaFuncionarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTelaFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFuncionarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEdição, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(273, 273, 273))
        );
        pnlTelaFuncionarioLayout.setVerticalGroup(
            pnlTelaFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaFuncionarioLayout.createSequentialGroup()
                .addComponent(lbCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(lbBemVindo)
                .addGap(18, 18, 18)
                .addComponent(bFuncionarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bEdição, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTelaFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTelaFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEdiçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEdiçãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bEdiçãoActionPerformed

    private void bFuncionarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFuncionarios1ActionPerformed
        // TODO add your handling code here:
        new CadastrarEditarFuncionarios().setVisible(true);
    }//GEN-LAST:event_bFuncionarios1ActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        new LoginFun().setVisible(true);
    }//GEN-LAST:event_bSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEdição;
    private javax.swing.JButton bFuncionarios1;
    private javax.swing.JButton bSair;
    private javax.swing.JLabel lbBemVindo;
    private javax.swing.JLabel lbCabecalho;
    private javax.swing.JPanel pnlTelaFuncionario;
    // End of variables declaration//GEN-END:variables
}
