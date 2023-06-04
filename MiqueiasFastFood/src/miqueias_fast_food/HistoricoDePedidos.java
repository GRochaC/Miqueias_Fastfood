package MiqueiasFastFood;

import java.util.ArrayList;
import java.time.LocalDate;
import java.io.*;

public class HistoricoDePedidos{
    private LocalDate data;
    private ArrayList<Pedido> pedidos;
    final String diretorioHistorico = "historico.txt";

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
}
