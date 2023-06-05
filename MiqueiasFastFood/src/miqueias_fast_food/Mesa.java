package miqueias_fast_food;

/*
 * Classe provisória para mesas:
 */
//import java.util.*;
//
//class Mesas{
//    private ArrayList<ArrayList<Mesa>> mesas = new ArrayList<ArrayList<Mesa>>();   
//    
//    public void checarDisponibilidade(){
//    for(ArrayList<Mesa> fileiraDeMesas : mesas)
//        for(Mesa mesa : fileiraDeMesas)
//            System.out.printf(mesa.getDisponivel() + " ");
//        System.out.println();
//    }
//}

public class Mesa{
    private int identificador;
    private byte tamanho;
    private boolean disponivel;

    public Mesa(int _identificador, byte _tamanho, boolean _disponivel){
        this.identificador = _identificador;
        this.tamanho = _tamanho;
        this.disponivel = _disponivel;
    }

    public int getIdentificador(){
        return this.identificador;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public boolean getDisponivel(){
        return this.disponivel;
    }
}
