
package telas;
import miqueias_fast_food.BooleanMutavel;
import miqueias_fast_food.CarregaItens;

import javax.swing.table.DefaultTableModel;
import miqueias_fast_food.Item;
import miqueias_fast_food.ItemParaEdicao;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * @author caleb
 */


public class EditarCardapio extends javax.swing.JFrame implements BooleanMutavel{
    // ArrayList auxiliar
    private ArrayList<Item> itens = MenuPrincipal.cardapio;

    private boolean confirmar = false;
    public void mudar(){
        confirmar = !confirmar;
    }


    public EditarCardapio() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        CarregaItens.carregarItens();
        itens = CarregaItens.getItens();

        lbCabecalho = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(242, 240, 229));

        lbCabecalho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cabecalho.png"))); // NOI18N
        

        // Índice auxiliar para popular a tabela 
        int i = 0;
        
        // Matriz de Object que irá conter os elementos da tabela 
        Object[][] objetoPadrao = new Object[itens.size()][1];
        for(Item item : itens){
            objetoPadrao[i][0] = item.getNome();
            ++i;
        }
        
        // Matriz de Object que irá conter os elementos da tabela que são selecionáveis para deleção
        Object[][] objetoSelecao = new Object[itens.size()][2];
        i = 0;
        for(Item item : itens){
            objetoSelecao[i][0] = item.getNome();
            objetoSelecao[i][1] = false;
            ++i;
        }
        
        // Modelo da tabela, usado para poder deletar itens
        modeloParaSelecao = new DefaultTableModel(objetoSelecao, new String[]{"Nome", "Deletar"}){
            @Override
            public Class<?> getColumnClass(int column){
                if(column == 1){
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        jTable2 = new JTable(modeloParaSelecao){
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 1) {
                    return getDefaultRenderer(Boolean.class); // Use the default Boolean renderer for checkboxes
                }
                return super.getCellRenderer(row, column);
            }

            @Override
            public TableCellEditor getCellEditor(int row, int column) {
                if (column == 1) {
                    return getDefaultEditor(Boolean.class); // Use the default Boolean editor for checkboxes
                }
                return super.getCellEditor(row, column);
            }  
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false; 
                return true;
            }
        };
        
        // Modelo da tabela, composto de nomes dos itens
        DefaultTableModel modeloPadrao = new DefaultTableModel(objetoPadrao, new String[]{"Nome"}){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        jTable2.setModel(modeloPadrao);

        jTable2.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N

        jScrollPane2.setViewportView(jTable2);

        jButton5.setBackground(new java.awt.Color(180, 82, 82));
        jButton5.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Editar selecionado");
        jButton5.setMargin(new java.awt.Insets(8, 28, 8, 28));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(180, 82, 82));
        jButton6.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Excluir itens");
        jButton6.setMargin(new java.awt.Insets(8, 28, 8, 28));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
                mudar();
            }
        });

        jButton7.setBackground(new java.awt.Color(180, 82, 82));
        jButton7.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Adicionar item");
        jButton7.setMargin(new java.awt.Insets(8, 28, 8, 28));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(180, 82, 82));
        jButton8.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Sair e salvar");
        jButton8.setMargin(new java.awt.Insets(8, 28, 8, 28));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbCabecalho)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbCabecalho)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton7)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(!confirmar){
            jTable2.setModel(modeloParaSelecao);
            jButton5.setEnabled(false);
            jButton6.setText("Confirmar");
            jButton7.setEnabled(false);
            jButton8.setEnabled(false);
        }else{
            jButton5.setEnabled(true);
            jButton6.setText("Excluir itens");
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            for(int i = 0; i < jTable2.getRowCount(); ++i)
                if((Boolean) jTable2.getValueAt(i,1) == true){
                    System.out.println("Deletado com sucesso");
                    CarregaItens.excluirItem((String) jTable2.getValueAt(i,0));
                }
            CarregaItens.carregarItens();
            MenuPrincipal.cardapio = CarregaItens.getItens();
            new EditarCardapio().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ItemParaEdicao.setItem(itens.get(jTable2.getSelectedRow()));
        ItemParaEdicao.setIndice(jTable2.getSelectedRow());
        new EditarItemCardapio().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new AdicionarItemCardapio().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(EditarCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCardapio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbCabecalho;
    private DefaultTableModel modeloParaSelecao;
    // End of variables declaration//GEN-END:variables
}
