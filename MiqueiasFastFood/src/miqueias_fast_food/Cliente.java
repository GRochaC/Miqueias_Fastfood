package miqueias_fast_food;

/**
 *
 * @author archago
 */
public class Cliente extends Pessoa{
    private boolean takeOut;
    private String dataDeAniversario;
    private String telefone;
    private Mesa mesa;
    private final Pedido pedido;

    public Cliente(boolean takeOut, String dataDeAniversario, String telefone, String cpf, String nome) {
        super(cpf, nome);
        this.takeOut = takeOut;
        this.dataDeAniversario = dataDeAniversario;
        this.telefone = telefone;
        this.mesa = null;
        this.pedido = new Pedido(this, 0, this.takeOut);
    }

    public Cliente(boolean takeOut, String dataDeAniversario, String telefone, Mesa mesa, String cpf, String nome) {
        super(cpf, nome);
        this.takeOut = takeOut;
        this.dataDeAniversario = dataDeAniversario;
        this.telefone = telefone;
        this.mesa = mesa;
        this.pedido = new Pedido(this, 0, this.takeOut);
    }
    
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isTakeOut() {
        return takeOut;
    }

    public void setTakeOut(boolean takeOut) {
        this.takeOut = takeOut;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
}
