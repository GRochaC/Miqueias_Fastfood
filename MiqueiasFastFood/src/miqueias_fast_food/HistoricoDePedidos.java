package miqueias_fast_food;

import java.util.ArrayList;
import java.time.LocalDate;
import java.io.*;

public class HistoricoDePedidos{

    // Usamos o LocalDate para adquirirmos a data do dia atual
    static private LocalDate data;

    // Atributo para se adicionar um identificador a cada pedido do dia
    static private int indiceDoPedido = 0;

    // Arquivo que mantém o registro de todos os pedidos feitos
    static final String DIRETORIO_HISTORICO = "historico.txt";

    // O relatório será um arquivo .txt e terá como nome a data do dia atual
    // E cada um será guardado numa pasta chamada relatorios
    static final String DIRETORIO_RELATORIO = "relatorios/" + LocalDate.now() + ".txt";

    // Ao final do dia, chamamos este método, que adiciona ao arquivo histórico cada 
    // pedido que temos armazenado no nosso ArrayList
    public static void escreverNoArquivo(Pedido pedido){
        try {
            data = LocalDate.now();
            BufferedWriter escritor = new BufferedWriter(new FileWriter(DIRETORIO_HISTORICO, true));
           
            /*
             * O histórico está no formato:
             * dd/mm/yyyy - R$xx.xx 
             * dd/mm/yyyy - R$yy.yy
             * ....
             *
             * Onde cada linha representa um pedido feito
             */

            escritor.write(data + " - R$" + pedido.getTotal());
            escritor.newLine();

            // Uma quebra de linha é feita no final por organização e o escritor é fechado
            escritor.newLine();
            escritor.close();
        } catch (IOException e) {
            
            // Se houver algum erro na escrita, mostre o erro.
            e.printStackTrace();
        }
    }

    // Método para criar um arquivo detalhando exatamente os pedidos feitos no dia
    public static void gerarRelatorio(Pedido pedido){
        try {

            FileWriter escritor = new FileWriter(DIRETORIO_RELATORIO, true);

            // Variável auxiliar para termos o identificador do pedido

            // ArrayList de cada item pedido no pedido
            ArrayList<ItemPedido> itensPedidos = pedido.getItensPedidos();

            /* 
             * O formato será:
             * Pedido i (R$xx.xx)
             * - qtd(x) x(s) 
             * - qtd(y) y(s)
             */
            
            escritor.write("Pedido " + indiceDoPedido + ": R$" + pedido.getTotal() + '\n');
            for(ItemPedido item : itensPedidos){
                escritor.write("- " + item.getQuantidade() + ' ' + item.getItem() + "(s)\n");
            }
            ++indiceDoPedido;

            // Quebra de linha no fim de cada pedido por organização
            escritor.write('\n');

            // Fecha o escritor
            escritor.close();
        } catch (IOException e) {

            // Se houver algum erro na leitura, mostrar o erro.
            e.printStackTrace();
        }
    }

}
