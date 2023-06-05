package miqueias_fast_food;

import java.util.*;

public class Mesas{
    private static ArrayList<ArrayList<Mesa>> mesas;   
    
    // verifica a disponibilidade de todas as mesas
    public void checarDisponibilidade(){
        for(ArrayList<Mesa> fileiraDeMesas : mesas)
            for(Mesa mesa : fileiraDeMesas)
                System.out.printf(mesa.getDisponivel() + " ");
            System.out.println();
    }

    // Função para marcar uma mesa como ocupada
    public void ocuparMesa(int i, int j){
        mesas.get(i).get(j).toggleDisponivel();
    }
    
    // Inicializa o conjunto de mesas, inicialmente com 16 mesas no total, cada 
    // uma com tamanho 2
    public static void main(String[] args){
        mesas = new ArrayList<>();
        int identificador = 0;
        for(int i = 0; i < 4; ++i){
              ArrayList<Mesa> fileira = new ArrayList<>();
              for(int j = 0; j < 4; ++j){
                    Mesa mesa = new Mesa(identificador, (byte) 2, true);
                    fileira.add(mesa);
                    ++identificador;
              }
        }         
    }
}
