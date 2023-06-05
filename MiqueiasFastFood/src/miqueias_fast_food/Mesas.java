package miqueias_fast_food;

import java.util.*;

public class Mesas{
    private static ArrayList<ArrayList<Mesa>> mesas;   
    
    // verifica a disponibilidade da mesa utilizando indices da matriz
    public static boolean checarDisponibilidade(int i, int j){
        return mesas.get(i).get(j).getDisponivel();
    }
    
    // verifica a disponibilidade da mesa utilizando o identificador da mesa
    public static boolean checarDisponibilidade(int identificador) {
        return mesas.get(identificador/4).get((identificador/4) * 4 - identificador).getDisponivel();
    }

    // Função para marcar uma mesa como ocupada utilizando indices da matriz
    public static void ocuparMesa(int i, int j){
        mesas.get(i).get(j).toggleDisponivel();
    }
    
    // Função para marcar uma mesa como ocupada utilizando o identificador da mesa
    public static void ocuparMesa(int identificador) {
        mesas.get(identificador/4).get((identificador/4) * 4 - identificador).toggleDisponivel();
    }
    
    // Inicializa o conjunto de mesas, inicialmente com 16 mesas no total, cada 
    // uma com tamanho 2
    public static void gerarMesas() {
        int identificador = 0;
        for(int i = 0; i < 4; i++) {
            ArrayList<Mesa> fileira = new ArrayList<>();
            for(int j = 0; j < 4; j++) {
                Mesa mesa = new Mesa(identificador, (byte) 2, true);
                fileira.add(mesa);
                ++identificador;
            }
            mesas.add(fileira);
        }
    }
    
    /*
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
    */
}
