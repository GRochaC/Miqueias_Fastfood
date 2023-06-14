package miqueias_fast_food;

// Classe que representa uma mesa no restaurante
public class Mesa{
    // identificador da mesa
    private int identificador;
    
    // quantas pessoas cabem na mesa
    private byte tamanho;
    
    // indica se a mesa está ocupada ou não
    private boolean disponivel;

    // Construtor da classe Mesa
    public Mesa(int _identificador, byte _tamanho, boolean _disponivel){
        this.identificador = _identificador;
        this.tamanho = _tamanho;
        this.disponivel = _disponivel;
    }

    // retorna o identificador da mesa
    public int getIdentificador(){
        return this.identificador;
    }

    // retorna quantas pessoas cabem na mesa
    public int getTamanho(){
        return this.tamanho;
    }

    // retorna se a mesa está ocupada ou não
    public boolean getDisponivel(){
        return this.disponivel;
    }

    // define se a mesa está ocupada ou não
    public void toggleDisponivel(){
        this.disponivel = !this.disponivel;
    }
}
