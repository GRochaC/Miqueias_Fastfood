package miqueias_fast_food;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

/*
 * @author guilherme
 * Classe responsável pela leitura dos objetos Item de um arquivo .txt
 */
public class CarregaItens {
    // ArrayList onde ficará armazenado os itens lidos do arquivo .txt
    private static ArrayList<Item> itens;
    
    // Nome do arquivo
    private static final String DIRETORIO = "Itens.txt";
    
    // Adjetivos para serem usados na descrição dos itens criados
    private static final String[] adjetivos_s_c = {"delicioso", "nutritivo", "muito saboroso",
                                    "majestoso", "apetitoso", "digno de realeza", "para os fortes"};
    private static final String[] adjetivos_sob = {"perfeita para um dia quente", 
                                    "perfeita para um dia frio", "que traz o conforto de casa de vó",
                                    "ótima para postar no Instagram"};
    private static final String[] adjetivos_b = {"perfeita para dias quentes", "perfeita"
                                        + " para dias frios", "bem geladinha", 
                                                 "que desce bem com qualquer coisa"};
    
    // método que lê do arquivo "Itens.txt" e cria os objetos Itens armazenados nele
    public static void carregarItens() {
        
        // É copiado o estoque para poder saber se um item pode ser adicionado a lista do cardápio
        
        HashMap<String,Integer> estoque = new HashMap<>(Estoque.getEstoque());

        itens = new ArrayList<>();
        try{
            BufferedReader leitor;
            // cria o leitor de arquivos
            leitor = new BufferedReader(new FileReader(DIRETORIO));
            
            String linha;
            while((linha = leitor.readLine()) != null) {
                // formatação do arquivo: nome;preco;kcal;g_total;carb;prot;tipo
                String[] elementos = linha.split(";");
                
                // declara e converte, para seus respectivos tipos, os atributos
                // do objeto Item
                String nome = elementos[0], tipo = elementos[6], descricao = null; 
                double preco = Double.parseDouble(elementos[1].replace(",", "."));
                float[] v_n = new float[4];
                for(int i = 2; i < 6; i++) v_n[i-2] = Float.parseFloat(elementos[i].replace(",", "."));
                TiposComida t_c = null;
                
                // declaração de um objeto Random
                Random rand = new Random();
                switch(tipo) {
                    case "Sanduíche": {
                        t_c = TiposComida.SANDUICHE;
                        
                        // Sorteia uma descrição aleatória
                        descricao = String.format("%s %s.", tipo, 
                                adjetivos_s_c[rand.nextInt(adjetivos_s_c.length)]);
                        break;
                    }
                    case "Cachorro-quente": {
                        t_c = TiposComida.CACHORRO_QUENTE;
                        
                        // Sorteia uma descrição aleatória
                        descricao = String.format("%s %s.", tipo, 
                                adjetivos_s_c[rand.nextInt(adjetivos_s_c.length)]);
                        break;
                    }
                    case "Bebida": {
                        t_c = TiposComida.BEBIDA;
                        
                        // Sorteia uma descrição aleatória
                        descricao = String.format("%s %s.", tipo, 
                                adjetivos_b[rand.nextInt(adjetivos_b.length)]);
                        break;
                    }
                    case "Sobremesa": {
                        t_c = TiposComida.SOBREMESA;
                        
                        // Sorteia uma descrição aleatória
                        descricao = String.format("%s %s.", tipo, 
                                adjetivos_sob[rand.nextInt(adjetivos_sob.length)]);
                        break;
                    }
                    default: break;
                }
                
                // criação do objeto Item
                Item item = new Item(nome, preco, v_n, t_c, descricao);
                
                // adiciona o item criado à ArrayList se, e somente se, sua quantidade for maior que 0
                // no Estoque
                if(estoque.get(item.getNome()) > 0)
                    itens.add(item);
            }
            
            // fecha o leitor do arquivo
            leitor.close();
        } catch (IOException | NumberFormatException ignException) {
            // ignora a excecao
        }
    }
    
    // método que retorna a ArrayList<Item> contendo os itens lidos do arquivo
    public static ArrayList<Item> getItens() {
        return itens;
    }
}
