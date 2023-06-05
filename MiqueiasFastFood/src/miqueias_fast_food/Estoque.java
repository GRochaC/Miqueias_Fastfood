package miqueias_fast_food;

import java.util.*;
import java.io.*;

class Estoque{
    private HashMap<String, Integer> ingredientes;
    private HashMap<String, Integer> indiceDosIngredientes;
    private final String diretorioEstoque = "estoque.txt";
    private int numeroDeLinhas = 1;


    // Popula o HashMap com o conteúdo encontrado no arquivo local estoque.txt
    public void atualizarEstoque(){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(this.diretorioEstoque));
            String linha;
            while((linha = leitor.readLine()) != null){
                // Em cada linha do estoque se tem o nome de um ingrediente junto com sua quantidade
                String[] conteudoDaLinha = linha.split(" ");
                ingredientes.put(conteudoDaLinha[0], Integer.parseInt(conteudoDaLinha[1]));

                // Salvamos a linha em que algo foi editado para a edição e remoção mais fácil
                indiceDosIngredientes.put(conteudoDaLinha[0], numeroDeLinhas);
                ++numeroDeLinhas;
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

    // Método para editar a quantidade disponível de um item
    public void editarItem(String nomeDoItem, int novaQuantidade){
        try {
            // Leia o arquivo e guarde cada uma das linhas num array
            File arquivo = new File(diretorioEstoque);
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String[] linhas = new String[(int) arquivo.length()];
            String linha;
            int indiceDeLinha = 0;
            while ((linha = leitor.readLine()) != null) {
                linhas[indiceDeLinha++] = linha;
            }
            leitor.close();

            // Modificando 
            linhas[indiceDosIngredientes.get(nomeDoItem) - 1] = nomeDoItem + " " + novaQuantidade;

            // Reescreve o arquivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo));
            for (String linhaAtualizada : linhas) {
                escritor.write(linhaAtualizada);
                escritor.newLine();
            }
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirItem(String nomeDoItem){
        try {
            // Leia o arquivo e guarde cada uma das linhas num array exceto o
            // índice da linha que queremos deletar
            File arquivo = new File(diretorioEstoque);
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String[] linhas = new String[(int) arquivo.length()];
            String linha;
            int indiceDeLinha = 0;

            while ((linha = leitor.readLine()) != null) {
                if(indiceDeLinha != indiceDosIngredientes.get(nomeDoItem))
                    linhas[indiceDeLinha++] = linha;
                else 
                    indiceDeLinha++;
            }

            leitor.close();

            // Reescreve o arquivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo));
            for (String linhaAtualizada : linhas) {
                escritor.write(linhaAtualizada);
                escritor.newLine();
            }
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mostra todos os ingredientes no estoque e sua exata quantidade
    public void contagemItens(){
        for(Map.Entry<String, Integer> ingrediente : ingredientes.entrySet()){
            System.out.printf("Há " + ingrediente.getValue() + "unidade(s) de " + ingrediente + "no estoque." );
        }
    }
}
