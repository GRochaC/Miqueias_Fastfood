/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import miqueias_fast_food.*;

/**
 *
 * @author Guilherme
 */
public class MenuPedido extends javax.swing.JFrame {
    static Pedido pedido;
    static Cliente cliente;

    public MenuPedido() {
        initComponents();
        
        Pedido pedido_aux = new Pedido(MenuPedido.cliente, TelaCliente.id_pedido, 
                MenuPedido.cliente.isTakeOut());
        pedido = pedido_aux;
        TelaCliente.id_pedido++;
        
        offBotoes();
        
        carregarMenu(cbFiltro.getSelectedIndex());
        
        atualizarListaPedido();
        
        atualizarValorTotal();
        
    }
    
    public MenuPedido(Cliente cliente, Pedido pedido){
        initComponents();
        
        setLocationRelativeTo(null);
        
        MenuPedido.pedido = pedido;
        MenuPedido.cliente = cliente;
        
        offBotoes();
        bConfirmar.setEnabled(true);
        
        carregarMenu(cbFiltro.getSelectedIndex());
        
        atualizarListaPedido();
        
        atualizarValorTotal();
        
    }
    
    private void offBotoes() {
        bAdd.setEnabled(false);
        bDel.setEnabled(false);
        bRemover.setEnabled(false);
        bConfirmar.setEnabled(false);
    }
    
    private void carregarMenu(int tipo){
        estoque = Estoque.getEstoque();

        DefaultTableModel tabela = new DefaultTableModel(new Object[] {"Nome", "Tipo", "Preço"},0);
        
        switch(tipo) {
            case 1:
                for(Item item : MenuPrincipal.cardapio) {
                    if(item.getTipo().equals("Cachorro-quente")) {
                        String preco_formatado = String.format("R$ %.2f", item.getPreco());
                        Object[] linha = {item.getNome(), item.getTipo(), preco_formatado};
                        tabela.addRow(linha);
                    }
                }
                break;
            case 2:
                for(Item item : MenuPrincipal.cardapio) {
                    if(item.getTipo().equals("Sanduíche")) {
                        String preco_formatado = String.format("R$ %.2f", item.getPreco());
                        Object[] linha = {item.getNome(), item.getTipo(), preco_formatado};
                        tabela.addRow(linha);
                    }
                }
                break;
            case 3:
                for(Item item : MenuPrincipal.cardapio) {
                    if(item.getTipo().equals("Bebida")) {
                        String preco_formatado = String.format("R$ %.2f", item.getPreco());
                        Object[] linha = {item.getNome(), item.getTipo(), preco_formatado};
                        tabela.addRow(linha);
                    }
                }
                break;
            case 4:
                for(Item item : MenuPrincipal.cardapio) {
                    if(item.getTipo().equals("Sobremesa")) {
                        String preco_formatado = String.format("R$ %.2f", item.getPreco());
                        Object[] linha = {item.getNome(), item.getTipo(), preco_formatado};
                        tabela.addRow(linha);
                    }
                }
                break;
            default:
                for(Item item : MenuPrincipal.cardapio) {
                    String preco_formatado = String.format("R$ %.2f", item.getPreco());
                    Object[] linha = {item.getNome(), item.getTipo(), preco_formatado};
                    tabela.addRow(linha);
                }
        }
        
        tbMenu.setModel(tabela);
    }
    
    private void carregarTabela(ArrayList<Item> itens_custom) {
        DefaultTableModel tabela = new DefaultTableModel(new Object[] {"Nome", "Tipo", "Preço"},0);
        for(Item item : itens_custom) {
            String preco_formatado = String.format("R$ %.2f", item.getPreco());
            Object[] linha = {item.getNome(), item.getTipo(), preco_formatado};
            tabela.addRow(linha);
        }
        tbMenu.setModel(tabela);
    }
    
    private void atualizarListaPedido(){
        DefaultListModel model = new DefaultListModel();
        if(!pedido.getItensPedidos().isEmpty()) {
            for(ItemPedido ip : pedido.getItensPedidos()){
                model.addElement(ip.toString());
            }
        }
        listaPedido.setModel(model);
        
        bConfirmar.setEnabled(!pedido.getItensPedidos().isEmpty());
    }
    
    private void atualizarValorTotal() {
        String valor_total_s = String.format("R$ %.2f", pedido.getTotal());
        lbValorTotal.setText(valor_total_s);
    }
    
    private void carregarInfoItem(Item item) {
        txtpNomeItem.setText(item.getNome());
        txtpTipoItem.setText(item.getTipo());
        txtpPrecoItem.setText(String.format("R$ %.2f", item.getPreco()));
        txtpDescricaoItem.setText(item.getDescricao());
        
        atualizarItem(item);
    }
    
    private void atualizarItem(Item item) {
        for(ItemPedido ip : pedido.getItensPedidos()) {
            if(ip.getItem().equals(item)) {
                lbQntItemPedido.setText(String.format("%d", ip.getQuantidade()));
                bDel.setEnabled(true);
                bAdd.setEnabled(true);
                return;
            }   
        }
        lbQntItemPedido.setText("0");
        bDel.setEnabled(false);
        bAdd.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenuPedido = new javax.swing.JPanel();
        lbCabecalho = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();
        spMenu = new javax.swing.JScrollPane();
        tbMenu = new javax.swing.JTable();
        pnlPedido = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lbTotal = new javax.swing.JLabel();
        spPedido = new javax.swing.JScrollPane();
        listaPedido = new javax.swing.JList<>();
        lbValorTotal = new javax.swing.JLabel();
        bRemover = new javax.swing.JButton();
        bConfirmar = new javax.swing.JButton();
        pnlItem = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbPreco = new javax.swing.JLabel();
        lbDescricao = new javax.swing.JLabel();
        lbValoresNutricionais = new javax.swing.JLabel();
        bDel = new javax.swing.JButton();
        bAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtpNomeItem = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtpPrecoItem = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtpDescricaoItem = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtpTipoItem = new javax.swing.JTextPane();
        lbQntItemPedido = new javax.swing.JLabel();
        bInfoNutri = new javax.swing.JButton();
        cbFiltro = new javax.swing.JComboBox<>();
        lbFiltro = new javax.swing.JLabel();
        lbPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Miqueias Fast Food - Cardápio");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_cachorro_quente.png")).getImage());

        pnlMenuPedido.setBackground(new java.awt.Color(244, 244, 244));

        lbCabecalho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cabecalho.png"))); // NOI18N

        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        spMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Emoji", 3, 12))); // NOI18N

        tbMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Tipo", "Preco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbMenu.setShowGrid(false);
        tbMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMenuMouseClicked(evt);
            }
        });
        spMenu.setViewportView(tbMenu);

        pnlPedido.setBackground(new java.awt.Color(244, 244, 244));
        pnlPedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTotal.setText("Total:");

        listaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPedidoMouseClicked(evt);
            }
        });
        spPedido.setViewportView(listaPedido);

        lbValorTotal.setText("-");

        bRemover.setText("Remover");
        bRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverActionPerformed(evt);
            }
        });

        bConfirmar.setText("Confirmar");
        bConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPedidoLayout = new javax.swing.GroupLayout(pnlPedido);
        pnlPedido.setLayout(pnlPedidoLayout);
        pnlPedidoLayout.setHorizontalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPedidoLayout.createSequentialGroup()
                        .addComponent(spPedido)
                        .addGap(18, 18, 18)
                        .addComponent(bRemover)
                        .addGap(24, 24, 24))
                    .addGroup(pnlPedidoLayout.createSequentialGroup()
                        .addComponent(lbTotal)
                        .addGap(18, 18, 18)
                        .addComponent(lbValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bConfirmar)
                        .addGap(23, 23, 23))))
        );
        pnlPedidoLayout.setVerticalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bRemover)
                    .addComponent(spPedido))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotal)
                    .addComponent(lbValorTotal)
                    .addComponent(bConfirmar))
                .addGap(31, 31, 31))
        );

        pnlItem.setBackground(new java.awt.Color(244, 244, 244));
        pnlItem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Emoji", 3, 12))); // NOI18N

        lbNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNome.setText("Nome:");

        lbTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTipo.setText("Tipo:");

        lbPreco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPreco.setText("Preço:");

        lbDescricao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDescricao.setText("Descrição:");

        lbValoresNutricionais.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbValoresNutricionais.setText("Valores Nutricionais:");

        bDel.setText("-");
        bDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelActionPerformed(evt);
            }
        });

        bAdd.setText("+");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        txtpNomeItem.setEditable(false);
        jScrollPane1.setViewportView(txtpNomeItem);

        txtpPrecoItem.setEditable(false);
        jScrollPane2.setViewportView(txtpPrecoItem);

        txtpDescricaoItem.setEditable(false);
        jScrollPane3.setViewportView(txtpDescricaoItem);

        txtpTipoItem.setEditable(false);
        jScrollPane4.setViewportView(txtpTipoItem);

        lbQntItemPedido.setText("0");

        bInfoNutri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/info.png"))); // NOI18N
        bInfoNutri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInfoNutriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlItemLayout = new javax.swing.GroupLayout(pnlItem);
        pnlItem.setLayout(pnlItemLayout);
        pnlItemLayout.setHorizontalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlItemLayout.createSequentialGroup()
                                .addComponent(lbPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlItemLayout.createSequentialGroup()
                                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome)
                                    .addComponent(lbTipo))
                                .addGap(12, 12, 12)
                                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(pnlItemLayout.createSequentialGroup()
                                        .addComponent(jScrollPane4)
                                        .addGap(85, 85, 85))))
                            .addGroup(pnlItemLayout.createSequentialGroup()
                                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bAdd)
                                    .addComponent(lbValoresNutricionais))
                                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlItemLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bInfoNutri))
                                    .addGroup(pnlItemLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbQntItemPedido)
                                        .addGap(37, 37, 37)
                                        .addComponent(bDel)
                                        .addGap(79, 79, 79)))))
                        .addGap(55, 55, 55))
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addComponent(lbDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)
                        .addGap(49, 49, 49))))
        );
        pnlItemLayout.setVerticalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItemLayout.createSequentialGroup()
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addGap(9, 9, 9)))
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addComponent(lbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addGap(9, 9, 9)))
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addComponent(lbPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                        .addGap(9, 9, 9)))
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addComponent(lbDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItemLayout.createSequentialGroup()
                        .addComponent(lbValoresNutricionais)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItemLayout.createSequentialGroup()
                        .addComponent(bInfoNutri)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bDel)
                        .addComponent(lbQntItemPedido))
                    .addComponent(bAdd))
                .addContainerGap())
        );

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tudo", "Cachorros-quentes", "Sanduíches", "Bebidas", "Sobremesas" }));
        cbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroItemStateChanged(evt);
            }
        });

        lbFiltro.setText("Filtro:");

        lbPesquisar.setText("Pesquisar:");

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuPedidoLayout = new javax.swing.GroupLayout(pnlMenuPedido);
        pnlMenuPedido.setLayout(pnlMenuPedidoLayout);
        pnlMenuPedidoLayout.setHorizontalGroup(
            pnlMenuPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuPedidoLayout.createSequentialGroup()
                        .addComponent(spMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMenuPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(bVoltar)
                    .addGroup(pnlMenuPedidoLayout.createSequentialGroup()
                        .addComponent(lbFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bBuscar)))
                .addGap(18, 18, 18))
            .addGroup(pnlMenuPedidoLayout.createSequentialGroup()
                .addComponent(lbCabecalho)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMenuPedidoLayout.setVerticalGroup(
            pnlMenuPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuPedidoLayout.createSequentialGroup()
                .addComponent(lbCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMenuPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFiltro)
                    .addComponent(lbPesquisar)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMenuPedidoLayout.createSequentialGroup()
                        .addComponent(pnlItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spMenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenuPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenuPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        // TODO add your handling code here:
        TelaCliente.cliente = cliente;
        this.dispose();
    }//GEN-LAST:event_bVoltarActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        if(tbMenu.getSelectedRow() >= 0) {
            int linha_item = tbMenu.getSelectedRow();
            String nome = tbMenu.getValueAt(linha_item, 0).toString();
            for(Item i : MenuPrincipal.cardapio) {
                if(i.getNome().equals(nome)) {
                    if(pedido.addItem(i, 1)){
                        atualizarItem(i);
                        atualizarListaPedido();
                        atualizarValorTotal();
                    }
                    return;
                }
            }
        }
    }//GEN-LAST:event_bAddActionPerformed

    private void bConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmarActionPerformed
        // TODO add your handling code here:
        ConfirmarPedido.cliente = cliente;
        ConfirmarPedido.pedido = pedido;
        new ConfirmarPedido().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bConfirmarActionPerformed

    private void cbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroItemStateChanged
        // TODO add your handling code here:
        int idx_filtro = cbFiltro.getSelectedIndex();
        carregarMenu(idx_filtro);
    }//GEN-LAST:event_cbFiltroItemStateChanged

    private void listaPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPedidoMouseClicked
        // TODO add your handling code here:
        if(!listaPedido.isSelectionEmpty()) bRemover.setEnabled(true);
    }//GEN-LAST:event_listaPedidoMouseClicked

    private void bRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverActionPerformed
        // TODO add your handling code here:
        int idx_item = listaPedido.getSelectedIndex();
        Item item_rmv = pedido.getItensPedidos().get(idx_item).getItem();
        pedido.getItensPedidos().remove(idx_item);
        atualizarItem(item_rmv);
        atualizarListaPedido();
        atualizarValorTotal();
        if(listaPedido.isSelectionEmpty()) bRemover.setEnabled(false);
    }//GEN-LAST:event_bRemoverActionPerformed

    private void tbMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMenuMouseClicked
        // TODO add your handling code here:
        try{
            int linha_item = tbMenu.getSelectedRow();
            String nome = tbMenu.getValueAt(linha_item, 0).toString();
            for(Item i : MenuPrincipal.cardapio) {
                if(i.getNome().equals(nome)) {
                    carregarInfoItem(i);
                    return;
                }
            }
        } catch (IndexOutOfBoundsException ignException){ }
    }//GEN-LAST:event_tbMenuMouseClicked

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        if(!txtPesquisar.getText().isBlank()) {
            String item_pesquisa = txtPesquisar.getText().toLowerCase();
            ArrayList<Item> itens_custom = new ArrayList<>();
            for(Item item : MenuPrincipal.cardapio) {
                if(item.getNome().toLowerCase().contains(item_pesquisa)) {
                    itens_custom.add(item);
                }
            }
            
            if(!itens_custom.isEmpty()) carregarTabela(itens_custom);
            else {
                JOptionPane.showMessageDialog(null, "Item não encontrado.", "Resultado da pesquisa", JOptionPane.PLAIN_MESSAGE);
                carregarMenu(0);
            }
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bInfoNutriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInfoNutriActionPerformed
        // TODO add your handling code here:
        Object[] opcoes = {"Próximo", "Cancelar"};
        if(tbMenu.getSelectedRow() >= 0) {
            Item i_selec = MenuPrincipal.cardapio.get(tbMenu.getSelectedRow());
            
            int linha_item = tbMenu.getSelectedRow();
            String nome = tbMenu.getValueAt(linha_item, 0).toString();
            for(Item i : MenuPrincipal.cardapio) {
                if(i.getNome().equals(nome)) {
                    i_selec = i;
                    break;
                }
            }
            
            float[] v_n = i_selec.getValoresNutriciais();
            String[] v_n_f = {String.format("Calorias: %.1fkcal", v_n[0]),
                              String.format("Gordura total: %.1fg", v_n[1]),
                              String.format("Carboidratos: %.1fg", v_n[2]),
                              String.format("Proteínas: %.1fg", v_n[3])};
            try {
                for(int i = 0; i < 4; i++) {
                    int op = JOptionPane.showOptionDialog(null, v_n_f[i], 
                            "Valores nutricionais", JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                    if(op != 0) break;
                }
            } catch (NullPointerException ignException) {
                // ignora
            }
        }
    }//GEN-LAST:event_bInfoNutriActionPerformed

    private void bDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelActionPerformed
        // TODO add your handling code here:
        if(tbMenu.getSelectedRow() >= 0) {
            int linha_item = tbMenu.getSelectedRow();
            String nome = tbMenu.getValueAt(linha_item, 0).toString();
            for(Item i : MenuPrincipal.cardapio) {
                if(i.getNome().equals(nome)) {
                    pedido.delItem(i, 1);
                    atualizarItem(i);
                    atualizarListaPedido();
                    atualizarValorTotal();
                    
                    return;
                }
            }
            
        }
    }//GEN-LAST:event_bDelActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bConfirmar;
    private javax.swing.JButton bDel;
    private javax.swing.JButton bInfoNutri;
    private javax.swing.JButton bRemover;
    private javax.swing.JButton bVoltar;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCabecalho;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbFiltro;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbQntItemPedido;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JLabel lbValoresNutricionais;
    private javax.swing.JList<String> listaPedido;
    private javax.swing.JPanel pnlItem;
    private javax.swing.JPanel pnlMenuPedido;
    private javax.swing.JPanel pnlPedido;
    private javax.swing.JScrollPane spMenu;
    private javax.swing.JScrollPane spPedido;
    private javax.swing.JTable tbMenu;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextPane txtpDescricaoItem;
    private javax.swing.JTextPane txtpNomeItem;
    private javax.swing.JTextPane txtpPrecoItem;
    private javax.swing.JTextPane txtpTipoItem;
    private HashMap<String,Integer> estoque;
    // End of variables declaration//GEN-END:variables
}
