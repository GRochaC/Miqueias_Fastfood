package projeto;

import java.util.*;
import java.io.*;

class Estoque{
    private HashMap<String, Integer> ingredientes;
    private final String diretorioEstoque = "estoque.txt";


    // Popula o HashMap com o conteúdo encontrado no arquivo local estoque.txt
    public void atualizarEstoque(){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(this.diretorioEstoque));
            String linha;
            while((linha = leitor.readLine()) != null){
                // Em cada linha do estoque se tem o nome de um ingrediente junto com sua quantidade
                String[] conteudoDaLinha = linha.split(" ");
                ingredientes.put(conteudoDaLinha[0], Integer.parseInt(conteudoDaLinha[1]));
            }
            leitor.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    // Método para se adicionar um item no estoque
    public void adicionarItem(String nomeDoItem, int quantidadeDoItem){

        // Não se pode utilizar esse método para editar itens
        if(ingredientes.containsKey(nomeDoItem))
            System.out.println("Item já está no estoque!");
        else{
            // Insere item no HashMap
            ingredientes.put(nomeDoItem, quantidadeDoItem);

            // Insere item no arquivo
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(this.diretorioEstoque));
                escritor.write(nomeDoItem + quantidadeDoItem);
                escritor.newLine();
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* 
     * Mais tarde adicionar os métodos de editar e remover itens 
     *
     */
   

    // Mostra todos os ingredientes no estoque e sua exata quantidade
    public void contagemItens(){
        for(Map.Entry<String, Integer> ingrediente : ingredientes.entrySet()){
            System.out.printf("Há " + ingrediente.getValue() + "unidade(s) de " + ingrediente + "no estoque." );
        }
    }
}
