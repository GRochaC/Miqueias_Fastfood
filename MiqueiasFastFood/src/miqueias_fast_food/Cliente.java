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
    private TiposPagamento pagamento;

    
    public Cliente(boolean takeOut, String cpf, String nome) {
        super(cpf, nome);
        this.takeOut = takeOut;
        this.pedido = new Pedido(this, 0, this.takeOut);
        this.mesa = null;
    }
    
    public Cliente(boolean takeOut, Mesa mesa, String cpf, String nome) {
        super(cpf, nome);
        this.takeOut = takeOut;
        this.pedido = new Pedido(this, 0, this.takeOut);
        this.mesa = mesa;
    }
    
    /*
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
*/

    public String getPagamento() {
        switch(pagamento) {
            case DINHEIRO: return "Dinheiro";
            case CARTAO_DE_CREDITO: return "Cartão de crédito";
            case PIX: return "Pix";
        }
        return null;
    }

    public void setPagamento(TiposPagamento pagamento) {
        this.pagamento = pagamento;
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
