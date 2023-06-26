/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import miqueias_fast_food.Estoque;

/**
 *
 * @author caleb
 */
 
class BooleanMutavel{
    boolean confirmar = false;
    public void mudar(){
        confirmar = !confirmar;
    }
    public boolean getValue(){
        return this.confirmar;
    }
}

public class EditarEstoque extends javax.swing.JFrame {
    JTable jTable2;
    /**
     * Creates new form EditarCardapio
     */
    public EditarEstoque() {
        initComponents();
    }

    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        Estoque.carregaEstoque();

        // Referência do hashmap de estoque
        estoque = new HashMap<>(Estoque.getEstoque());

        // Índice auxiliar para popular a tabela 
        int i = 0;

        // Matriz de Object que irá conter os elementos da tabela 
        Object[][] objetoPadrao = new Object[estoque.size()][2];
        for(HashMap.Entry<String,Integer> ingrediente : estoque.entrySet()){
            System.out.println(ingrediente.getKey() + " " + ingrediente.getValue());
            objetoPadrao[i][0] = ingrediente.getKey();
            objetoPadrao[i][1] = String.valueOf(ingrediente.getValue());
            ++i;
        }

        // Modelo da tabela, composto dos itens do hashmap, suas quantidades e o título de cada atributo
        DefaultTableModel modeloPadrao = new DefaultTableModel(objetoPadrao, new String[]{"Nome", "Quantidade"}){};

        Object[][] objetoSelecao = new Object[estoque.size()][3];
        i = 0;
        for(HashMap.Entry<String,Integer> ingrediente : estoque.entrySet()){
            objetoSelecao[i][0] = ingrediente.getKey();
            objetoSelecao[i][1] = ingrediente.getValue();
            objetoSelecao[i][2] = false;
            ++i;
        }
        
        // Modelo da tabela, usado para poder deletar itens
        modeloParaSelecao = new DefaultTableModel(objetoSelecao, new String[]{"Nome", "Quantidade", "Deletar"}){
            @Override
            public Class<?> getColumnClass(int column){
                if(column == 2){
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }
        };
        jTable2 = new JTable(modeloParaSelecao){
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 2) {
                    return getDefaultRenderer(Boolean.class); // Use the default Boolean renderer for checkboxes
                }
                return super.getCellRenderer(row, column);
            }

            @Override
            public TableCellEditor getCellEditor(int row, int column) {
                if (column == 2) {
                    return getDefaultEditor(Boolean.class); // Use the default Boolean editor for checkboxes
                }
                return super.getCellEditor(row, column);
            }  
        };

        jTable2.setModel(modeloPadrao);
        jTable2.setModel(modeloParaSelecao);
        jTable2.setModel(modeloPadrao);

        lbCabecalho = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(242, 240, 229));

        lbCabecalho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cabecalho.png"))); // NOI18N

        jTable2.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N

        jScrollPane2.setViewportView(jTable2);

        jButton5.setBackground(new java.awt.Color(180, 82, 82));
        jButton5.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Adicionar itens");
        jButton5.setMargin(new java.awt.Insets(8, 28, 8, 28));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        BooleanMutavel confirmar = new BooleanMutavel();
        jButton6.setBackground(new java.awt.Color(180, 82, 82));
        jButton6.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Excluir itens");
        jButton6.setBorderPainted(false);
        jButton6.setMargin(new java.awt.Insets(8, 28, 8, 28));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt, confirmar.getValue(), jTable2.getRowCount());
                confirmar.mudar();
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(jButton8)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Botão de deletar itens
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt, boolean confirmar, int n) {//GEN-FIRST:event_jButton6ActionPerformed
        if(!confirmar){
            jTable2.setModel(modeloParaSelecao);
            jButton5.setEnabled(false);
            jButton6.setText("Confirmar");
            jButton8.setEnabled(false);
        }else{
            jButton5.setEnabled(true);
            jButton6.setText("Excluir itens");
            jButton8.setEnabled(true);
            for(int i = 0; i < n; ++i)
                if((Boolean) jTable2.getValueAt(i,2) == true){
                    System.out.println((String) jTable2.getValueAt(i, 0));
                    Estoque.excluirItem((String) jTable2.getValueAt(i,0));
                }
            Estoque.carregaEstoque();
            new EditarEstoque().setVisible(true);
            dispose();
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new AdicionarItemEstoque().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        HashMap<String,Integer> novoEstoque = new HashMap<>();
        for(int i = 0; i < jTable2.getRowCount(); ++i){
            System.out.println(jTable2.getValueAt(i, 0));
            novoEstoque.put((String) jTable2.getValueAt(i,0), Integer.parseInt((String) jTable2.getValueAt(i,1)));            

        }
        Estoque.setEstoque(novoEstoque);
        Estoque.reescreveEstoque();
        Estoque.carregaEstoque();
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
            java.util.logging.Logger.getLogger(EditarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarEstoque().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCabecalho;
    private DefaultTableModel modeloParaSelecao;
    private HashMap<String,Integer> estoque;
    // End of variables declaration//GEN-END:variables
}
////