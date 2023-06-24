package miqueias_fast_food;

/**
 * @author Caleb:
 * Classe auxiliar que irá possuir cada característica de um item 
 * no estoque
 */

public class Propriedades {
    private int quantidade, valorNutricional;
    private float preco;
    private String tipo; 
    
    public Propriedades(int quantidade, float preco, int valorNutricional, String tipo){
        this.quantidade = quantidade;
        this.preco = preco;
        this.valorNutricional = valorNutricional;
        this.tipo = tipo;
    }

    public int getQuantidade(){
        return this.quantidade;
    }
    public float getPreco(){
        return this.preco;
    }
    public int getValorNutricional(){
        return this.valorNutricional;
    }
    public String getTipo(){
        return this.tipo;
    }
}
