package miqueias_fast_food;

import java.util.*;
import java.io.*;

/**
 * @author Caleb:
 * Classe que mantém o conteúdo do que está no estoque do estabelecimento
 */

public class Estoque{
    
    // HashMap para manter os ingredientes e sua respectiva quantidade 
    private static HashMap<String, Integer> ingredientes = new HashMap<>();
    
    private final static String DIRETORIO_ESTOQUE = "estoque.txt";
    
    // Contador de linhas para ajudar a saber em qual linha está cada ingrediente 
    private static int numeroDeLinhas = 1;

    // HashMap para guardar a linha em que cada ingrediente se encontra no arquivo, para a 
    // deleção e edição rápida
    private static HashMap<String, Integer> indiceDosIngredientes = new HashMap<>();


    // Popula o HashMap com o conteúdo encontrado no arquivo local estoque.txt
    public static void carregaEstoque(){
        try{
            // Leitor de arquivos 
            BufferedReader leitor = new BufferedReader(new FileReader(DIRETORIO_ESTOQUE));
            
            // Cada linha vista no arquivo é salva em uma String 
            ingredientes.clear();
            indiceDosIngredientes.clear();
            numeroDeLinhas = 1;
            String linha;
            while((linha = leitor.readLine()) != null){
                
                // Em cada linha do estoque se tem o nome de um ingrediente junto com sua quantidade 
                // separados por espaço
                String[] conteudoDaLinha = linha.split(";");
                ingredientes.put(conteudoDaLinha[0], Integer.parseInt(conteudoDaLinha[1]));

                // Coloca em indiceDosIngredientes o nome do ingrediente visto e sua respectiva linha 
                // no arquivo
                indiceDosIngredientes.put(conteudoDaLinha[0], numeroDeLinhas);
                ++numeroDeLinhas;
            }
            
            // Fecha o leitor depois de ler todas as linhas
            leitor.close();
        }catch(IOException e){
            // Ignora a exceção
        }
    }

    // Método para reescrever do zero o arquivo quando algum item
    // é editado no estoque
    public static void reescreveEstoque(){
        try {

            // Leia o arquivo e guarde cada uma das linhas num array exceto a linha 
            // que possui o índice da linha que queremos deletar

            BufferedWriter escritor = new BufferedWriter(new FileWriter(DIRETORIO_ESTOQUE, false));

            for (HashMap.Entry<String,Integer> linha : ingredientes.entrySet()) {
                escritor.write(String.format("%s;%d",linha.getKey() , linha.getValue()));
                escritor.newLine();
            }
            
            // Fecha o escritor
            escritor.close();


        } catch (IOException e) {
            // Ignora a exceção
        }
    }


    // Método para se adicionar um item ao estoque
    public static boolean adicionarItem(String nomeDoItem, int quantidadeDoItem){

        // Este método não edita itens, logo se um item já está no estoque,
        // é avisado que ele já está no estoque e é retornado falso
        if(ingredientes.containsKey(nomeDoItem))
            return false;
        try {
            // Insere item no arquivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(DIRETORIO_ESTOQUE, true));
            escritor.write(String.format("%s;%d", nomeDoItem, quantidadeDoItem));
            escritor.newLine();
            
            // Insere item no HashMap de ingredientes e guarda em qual linha ele se encontra no arquivo 
            ingredientes.put(nomeDoItem, quantidadeDoItem);
            indiceDosIngredientes.put(nomeDoItem, numeroDeLinhas);
            ++numeroDeLinhas;

            // Fecha o escritor
            escritor.close();

        } catch (IOException e) {
            // Ignora a exceção
        }
        
        // Se deu tudo certo, é retornado true
        return true;
    }

    public static void excluirItem(String nomeDoItem){
        try {

            // Leia o arquivo e guarde cada uma das linhas num array exceto a linha 
            // que possui o índice da linha que queremos deletar

            // Leitor do arquivo
            File arquivo = new File(DIRETORIO_ESTOQUE);
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));

            // Array de linhas
            String[] linhas = new String[numeroDeLinhas-1];

            // Variáveis auxiliares para cada linha e o índice de cada linha
            String linha;
            int indiceDeLinha = 0;

            while ((linha = leitor.readLine()) != null) {
                // Se a linha atual não é a linha que queremos deletar, adiciona ela ao array de linhas
                if(indiceDeLinha != indiceDosIngredientes.get(nomeDoItem) - 1){
                    linhas[indiceDeLinha++] = linha;
                }
                else 
                    ++indiceDeLinha;
            }

            // Fecha o leitor
            leitor.close();

            // Reescreve o arquivo no modo de sobreescrita
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, false));
            for (String linhaAtualizada : linhas) {
                // Compensa para a linha vazia que estará  no array
                if(linhaAtualizada != null){
                    escritor.write(linhaAtualizada);
                    escritor.newLine();
                }
            }
            
            // Subtrai o número de linhas 
            --numeroDeLinhas;

            // Fecha o escritor
            escritor.close();

        } catch (IOException e) {
            // Ignora a exceção
        }
    }

    public static HashMap<String, Integer> getEstoque(){
        return Estoque.ingredientes;
    }

    public static void setEstoque(HashMap<String,Integer> estoque){
        ingredientes = new HashMap<>(estoque);
    }
}
