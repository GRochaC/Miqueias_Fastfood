package miqueias_fast_food;

import java.util.ArrayList;
import java.time.LocalDate;
import java.io.*;

public class HistoricoDePedidos{
    private LocalDate data;
    private ArrayList<Pedido> pedidos;
    final String diretorioHistorico = "historico.txt";
    final String diretorioRelatorio = LocalDate.now() + ".txt";

    public void adicionarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    // Adiciona ao arquivo linhas para cada um dos pedidos
    public void gerarArquivo(){
        try {
            data = LocalDate.now();
            BufferedWriter escritor = new BufferedWriter(new FileWriter(this.diretorioHistorico));
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
    public void gerarRelatorio(){
        try {
            FileWriter escritor = new FileWriter(diretorioRelatorio);
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
