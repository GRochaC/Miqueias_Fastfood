/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import miqueias_fast_food.*;
/**
 *
 * @author Guilherme
 */
public class Pagamento extends javax.swing.JFrame {
    static Cliente cliente;
    static Pedido pedido;
    private boolean nome = false, cpf = false, telefone = false, pagamento = false,
            dia = false, mes = false, ano = false;
    
    public Pagamento() {
        initComponents();
        
        checkDescontos();
        
        checkConfirmar();
    }
    
    private void checkAniversario() {
        if(dia && mes && ano) {
            String aniversario = String.format("%s/%s/%s", cbDia.getItemAt(cbDia.getSelectedIndex()),
                    cbMes.getItemAt(cbMes.getSelectedIndex()),
                    cbAno.getItemAt(cbAno.getSelectedIndex()));
            cliente.setDataDeAniversario(aniversario);
            
            int d = Integer.parseInt(cbDia.getItemAt(cbDia.getSelectedIndex()));
            int m = Integer.parseInt(cbMes.getItemAt(cbMes.getSelectedIndex()));

            boolean disc = MenuPrincipal.data_atual.getDayOfMonth() == d &&
                    MenuPrincipal.data_atual.getMonthValue()== m;
            pedido.setDescontoSobremesa(disc);
            
            checkDescontos();
        }
    }
    
    private void checkConfirmar() {
        boolean estado = nome && cpf && telefone && pagamento;
        bConfirmar.setEnabled(estado);
    }
    
    private void checkDescontos(){
        double valor_final = pedido.getTotal();
        String valor_total = String.format("R$ %.2f\n", valor_final);
        if(pedido.isDescontoSobremesa()) {
            double desconto = 0.0;
            for(ItemPedido ip : pedido.getItensPedidos()) {
                if(ip.getItem().getTipo().equals("Sobremesa")) {
                    desconto += ip.getSubtotal() * 0.15;
                }
            }
            String desconto_sobremesa = String.format("-R$ %.2f (15%% de desconto em Sobremesas)\n", desconto);
            valor_total += desconto_sobremesa;
            valor_final -= desconto;
        }
        if(cbMetPagamento.getSelectedIndex() == 1) {
            double desconto = valor_final - Math.floor(valor_final);
            desconto += Math.floor(valor_final * 0.05);
            String desconto_dinheiro = String.format("-R$ %.2f (%.2f%% de desconto "
                    + "por pagamento em dinheiro)\n", desconto, desconto/pedido.getTotal()*100);
            valor_total += desconto_dinheiro;
            valor_final -= desconto;
        }
        
        valor_total += String.format("\nR$ %.2f (Valor final)", valor_final);
        
        txtpValorTotalFinal.setText(valor_total);
    }
    
    private boolean validarCPF(String CPF) {
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPagamento = new javax.swing.JPanel();
        lbCabecalho = new javax.swing.JLabel();
        pnlInfoCliente = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        lbDataAniversario = new javax.swing.JLabel();
        bInfo = new javax.swing.JButton();
        lbMetPagamento = new javax.swing.JLabel();
        cbMetPagamento = new javax.swing.JComboBox<>();
        lbTelefone = new javax.swing.JLabel();
        ftxtCPF = new javax.swing.JFormattedTextField();
        bCancelar = new javax.swing.JButton();
        bConfirmar = new javax.swing.JButton();
        bVoltar = new javax.swing.JButton();
        ftxtTelefone = new javax.swing.JFormattedTextField();
        lbValorTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtpValorTotalFinal = new javax.swing.JTextPane();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAno = new javax.swing.JComboBox<>();
        bOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Miqueias Fast Food - Informações do Cliente");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_cachorro_quente.png")).getImage());

        pnlPagamento.setBackground(new java.awt.Color(244, 244, 244));

        lbCabecalho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cabecalho.png"))); // NOI18N

        pnlInfoCliente.setBackground(new java.awt.Color(244, 244, 244));
        pnlInfoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Emoji", 3, 12))); // NOI18N

        lbNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNome.setText("Nome*:");

        txtNome.setToolTipText("Campo obrigatório");
        txtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeCaretUpdate(evt);
            }
        });

        lbCPF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCPF.setText("CPF*:");

        lbDataAniversario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDataAniversario.setText("Data de Aniversário:");

        bInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/info.png"))); // NOI18N
        bInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInfoActionPerformed(evt);
            }
        });

        lbMetPagamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMetPagamento.setText("Método de Pagamento*:");

        cbMetPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um método de pagamento", "Dinheiro", "Cartão de Crédito", "Pix" }));
        cbMetPagamento.setToolTipText("Campo obrigatório");
        cbMetPagamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMetPagamentoItemStateChanged(evt);
            }
        });

        lbTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTelefone.setText("Telefone*:");

        try {
            ftxtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtCPF.setToolTipText("Campo obrigatório");
        ftxtCPF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ftxtCPFCaretUpdate(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bConfirmar.setText("Confirmar");
        bConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmarActionPerformed(evt);
            }
        });

        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        try {
            ftxtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtTelefone.setToolTipText("Campo obrigatório");
        ftxtTelefone.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ftxtTelefoneCaretUpdate(evt);
            }
        });

        lbValorTotal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lbValorTotal.setText("Valor Total:");

        txtpValorTotalFinal.setEditable(false);
        jScrollPane1.setViewportView(txtpValorTotalFinal);

        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));

        cbAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        bOk.setText("Ok");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInfoClienteLayout = new javax.swing.GroupLayout(pnlInfoCliente);
        pnlInfoCliente.setLayout(pnlInfoClienteLayout);
        pnlInfoClienteLayout.setHorizontalGroup(
            pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMetPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                                        .addComponent(lbDataAniversario, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbMetPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bOk)
                                        .addGap(18, 18, 18)
                                        .addComponent(bInfo)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                                .addComponent(lbTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtTelefone))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoClienteLayout.createSequentialGroup()
                                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCPF))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftxtCPF)
                                    .addComponent(txtNome)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoClienteLayout.createSequentialGroup()
                        .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(lbValorTotal))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoClienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bVoltar)
                                .addGap(74, 74, 74)))
                        .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(124, 124, 124)
                                .addComponent(bConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane1)))))
                .addGap(114, 114, 114))
        );
        pnlInfoClienteLayout.setVerticalGroup(
            pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoClienteLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbDataAniversario)
                        .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bOk))
                    .addComponent(bInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMetPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMetPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbValorTotal)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(pnlInfoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVoltar)
                    .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPagamentoLayout = new javax.swing.GroupLayout(pnlPagamento);
        pnlPagamento.setLayout(pnlPagamentoLayout);
        pnlPagamentoLayout.setHorizontalGroup(
            pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagamentoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(pnlInfoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPagamentoLayout.setVerticalGroup(
            pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagamentoLayout.createSequentialGroup()
                .addComponent(lbCabecalho)
                .addGap(51, 51, 51)
                .addComponent(pnlInfoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        // TODO add your handling code here:
        ConfirmarPedido.cliente = cliente;
        ConfirmarPedido.pedido = pedido;
        new ConfirmarPedido().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bVoltarActionPerformed

    private void bConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmarActionPerformed
        cliente.setNome(txtNome.getText());
        cliente.setCpf(ftxtCPF.getText());
        cliente.setTelefone(ftxtTelefone.getText());
        
        MenuPrincipal.pedidos_do_dia.add(pedido);
        HistoricoDePedidos.escreverNoArquivo(pedido);
        HistoricoDePedidos.gerarRelatorio(pedido);
        
        JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!", "Pagamento realizado", 
                JOptionPane.DEFAULT_OPTION);
        
        this.dispose();
    }//GEN-LAST:event_bConfirmarActionPerformed

    private void bInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInfoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Informe sua data de aniversário para "
                + "receber 15% de desconto em Sobremesas!", "Desconto", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bInfoActionPerformed

    private void cbMetPagamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMetPagamentoItemStateChanged
        // TODO add your handling code here:
        int idx_pagamento = cbMetPagamento.getSelectedIndex();
        if(idx_pagamento > 0) {
            pagamento = true;
            switch(idx_pagamento) {
                case 1:
                    cliente.setPagamento(TiposPagamento.DINHEIRO);
                    break;
                case 2:
                    cliente.setPagamento(TiposPagamento.DINHEIRO);
                    break;
                case 3:
                    cliente.setPagamento(TiposPagamento.PIX);
                    break;
            }
            checkConfirmar();
            checkDescontos();
        }
    }//GEN-LAST:event_cbMetPagamentoItemStateChanged

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
        // TODO add your handling code here:
        int idx_dia = cbDia.getSelectedIndex();
        int idx_mes = cbMes.getSelectedIndex();
        int idx_ano = cbAno.getSelectedIndex();
        
        dia = idx_dia > 0;
        mes = idx_mes > 0;
        ano = idx_ano > 0;
        
        checkAniversario();
    }//GEN-LAST:event_bOkActionPerformed

    private void txtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeCaretUpdate
        // TODO add your handling code here:
        nome = !txtNome.getText().isBlank();
        checkConfirmar();
    }//GEN-LAST:event_txtNomeCaretUpdate

    private void ftxtCPFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ftxtCPFCaretUpdate
        // TODO add your handling code here:
        if(!ftxtCPF.getText().isBlank() 
                && ftxtCPF.getText().charAt(ftxtCPF.getText().length()-1) != ' '
                && ftxtCPF.getText().length() == 11) {
            cpf = validarCPF(ftxtCPF.getText());
            if(!cpf) {
                try{
                ftxtCPF.setText("");
                JOptionPane.showMessageDialog(null, "CPF inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalStateException igException) {}
            }
            checkConfirmar();
        }
    }//GEN-LAST:event_ftxtCPFCaretUpdate

    private void ftxtTelefoneCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ftxtTelefoneCaretUpdate
        // TODO add your handling code here:
        telefone = !ftxtTelefone.getText().equals("(  )       -    ");
        checkConfirmar();
    }//GEN-LAST:event_ftxtTelefoneCaretUpdate

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        try {
            String aviso = "Você deseja cancelar o pedido? Digite \"CANCELAR\" para cancelar o pedido.";
            String cancelar =JOptionPane.showInputDialog(null, aviso, "Cancelamento de pedido", 
                    JOptionPane.WARNING_MESSAGE);
            if(cancelar.equals("CANCELAR")) this.dispose();
        } catch (NullPointerException ignorException){}
    }//GEN-LAST:event_bCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bConfirmar;
    private javax.swing.JButton bInfo;
    private javax.swing.JButton bOk;
    private javax.swing.JButton bVoltar;
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JComboBox<String> cbMetPagamento;
    private javax.swing.JFormattedTextField ftxtCPF;
    private javax.swing.JFormattedTextField ftxtTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCabecalho;
    private javax.swing.JLabel lbDataAniversario;
    private javax.swing.JLabel lbMetPagamento;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JPanel pnlInfoCliente;
    private javax.swing.JPanel pnlPagamento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextPane txtpValorTotalFinal;
    // End of variables declaration//GEN-END:variables
}
