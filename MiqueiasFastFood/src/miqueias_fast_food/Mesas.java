package miqueias_fast_food;

import java.util.*;

// Classe que representa o salão de mesas do restaurante
public class Mesas{
    private static final ArrayList<ArrayList<Mesa>> mesas = new ArrayList<>();
    private static int mesas_ocupadas = 0;
    
    // verifica a disponibilidade da mesa utilizando indices da matriz
    public static boolean checarDisponibilidade(int i, int j){
        return mesas.get(i).get(j).getDisponivel();
    }
    
    // verifica a disponibilidade da mesa utilizando o identificador da mesa
    public static boolean checarDisponibilidade(int identificador) {
        identificador--;
        return mesas.get((int)identificador/4).get(identificador % 4).getDisponivel();
    }

    // Função para marcar uma mesa como ocupada utilizando indices da matriz
    public static void ocuparMesa(int i, int j){
        mesas.get(i).get(j).toggleDisponivel();
    }
    
    // Função para marcar uma mesa como ocupada utilizando o identificador da mesa
    public static void ocuparMesa(int identificador) {
        identificador--;
        mesas.get((int)identificador/4).get(identificador % 4).toggleDisponivel();
    }
    
    // Função para retornar uma mesa utilizando o identificador da mesa
    public static Mesa getMesa(int identificador) {
        identificador--;
        return mesas.get((int)identificador/4).get(identificador % 4);
    }
    
    // Função para retornar uma mesa utilizando indices da matriz
    public static Mesa getMesa(int i, int j) {
        return mesas.get(i).get(j);
    }
    
    // Inicializa o conjunto de mesas, inicialmente com 16 mesas no total, cada 
    // uma com tamanho 2
    public static void gerarMesas() {
        int identificador = 1;
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

    // retonar a matriz de mesas
    public static ArrayList<ArrayList<Mesa>> getMesas() {
        return mesas;
    }
    
    // retorna a quantidade de mesas ocupadas
    public static int getMesasOcupadas() {
        return mesas_ocupadas;
    }
    
    // incrementa ou decrementa a quantidade de mesas ocupadas
    public static void incrementarMesasOcupadas(int i) {
        mesas_ocupadas += i;
    }
    
}
