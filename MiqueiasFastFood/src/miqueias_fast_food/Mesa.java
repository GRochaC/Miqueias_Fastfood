package miqueias_fast_food;


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

    public void toggleDisponivel(){
        this.disponivel = !this.disponivel;
    }
}
