package miqueias_fast_food;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import java.util.HashMap;

/*
 * @author guilherme
 * Classe responsável pela leitura dos objetos Item de um arquivo .txt
 */
public abstract class CarregaItens {
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
            itens.clear();
            BufferedReader leitor;
            // cria o leitor de arquivos
            leitor = new BufferedReader(new FileReader(DIRETORIO));
            
            String linha;
            while((linha = leitor.readLine()) != null && !(linha.equals(""))) {
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
                if(estoque != null && estoque.containsKey(item.getNome()) &&  estoque.get(item.getNome()) > 0){
                    itens.add(item);
                }
            }
            
            // fecha o leitor do arquivo
            leitor.close();
        } catch (IOException | NumberFormatException ignException) {
            // ignora a excecao
        }
    }
    
    // Método para reescrever do zero o arquivo quando algum item
    // é editado no estoque
    public static void reescreveCardapio(){
        try {

            // Leia o arquivo e guarde cada uma das linhas num array exceto a linha 
            // que possui o índice da linha que queremos deletar

            BufferedWriter escritor = new BufferedWriter(new FileWriter(DIRETORIO, false));

            for (Item item : itens) {
                escritor.write(String.format("%s;%.2f;%.1f;%.1f;%.1f;%.1f;%s", item.getNome(), item.getPreco(),
                item.getValoresNutriciais()[0], item.getValoresNutriciais()[1], item.getValoresNutriciais()[2], item.getValoresNutriciais()[3],item.getTipo()));
                escritor.newLine();
            }
            
            // Fecha o escritor
            escritor.close();


        } catch (IOException e) {
            // Ignora a exceção
        }
    }
    
    // Método para se adicionar um item ao cardápio
    public static void adicionarItem(String nome, float preco, float[] valoresNutricionais, String tipo){
        try {
            // Insere item no arquivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(DIRETORIO, true));
            escritor.write(String.format("%s;%.2f;%.1f;%.1f;%.1f;%.1f;%s", nome, preco,
            valoresNutricionais[0], valoresNutricionais[1], valoresNutricionais[2], valoresNutricionais[3], tipo));
            escritor.newLine();
            
            // Fecha o escritor
            escritor.close();
            carregarItens();

        } catch (IOException e) {
            // Ignora a exceção
        }
    }

    // Método para se remover um item do cardápio
    public static void excluirItem(String nome){
        try {
            // Leia o arquivo e guarde cada uma das linhas num array exceto a linha 
            // cujo nome do item é o que queremos remover

            // Leitor do arquivo
            File arquivo = new File(DIRETORIO);
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));

            // Array de linhas
            ArrayList<String> linhas = new ArrayList<>();

            // Variáveis auxiliares para cada linha e o índice de cada linha
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] conteudoDaLinha = linha.split(";");
                // Se a linha atual não é a linha que queremos deletar, adiciona ela ao array de linhas
                if(!(conteudoDaLinha[0].equals(nome))){
                    //System.out.println("Entrei aqui: " + nome + " " + conteudoDaLinha[0]);   
                    linhas.add(linha);
                }
            }

            // Fecha o leitor
            leitor.close();

            // Reescreve o arquivo no modo de sobreescrita
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, false));
            for (String linhaAtualizada : linhas) {
                escritor.write(linhaAtualizada);
                escritor.newLine();
            }
            if(linhas.isEmpty()){
                escritor.write("");
                escritor.newLine();
            }

            // Fecha o escritor
            escritor.close();

        } catch (IOException e) {
            // Ignora a exceção
        }
    }

    // método que retorna a ArrayList<Item> contendo os itens lidos do arquivo
    public static ArrayList<Item> getItens() {
        return itens;
    }

    public static void setItens(ArrayList<Item> novosItens) {
        itens = new ArrayList<>(novosItens);
    }
}
