package miqueias_fast_food;

import java.util.ArrayList;
import java.time.LocalDate;
import java.io.*;

public class HistoricoDePedidos{
    static private LocalDate data;
    static private ArrayList<Pedido> pedidos;
    static final String DIRETORIO_HISTORICO = "historico.txt";
    static final String DIRETORIO_RELATORIO = LocalDate.now() + ".txt";

    public static void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    // Adiciona ao arquivo linhas para cada um dos pedidos
    public static void gerarArquivo(){
        try {
            data = LocalDate.now();
            BufferedWriter escritor = new BufferedWriter(new FileWriter(DIRETORIO_HISTORICO));
            for(Pedido pedido : pedidos){
                escritor.write(data + ": R$" + pedido.getTotal());
                escritor.newLine();
            }
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cria um arquivo relatório com o nome sendo data atual
    public static void gerarRelatorio(){
        try {
            FileWriter escritor = new FileWriter(DIRETORIO_RELATORIO);
            int indiceDoPedido = 0;
            for(Pedido pedido : pedidos){
                ArrayList<ItemPedido> itensPedidos = pedido.getItensPedidos();
                escritor.write(indiceDoPedido + ": " + pedido.getTotal() + '\n');
                for(ItemPedido item : itensPedidos){
                    escritor.write("- " + item + '\n');
                }
                ++indiceDoPedido;
            }
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
