package miqueias_fast_food;

/**
 * @author archago
 * Classe que representa o cliente no sistema
 */
public class Cliente extends Pessoa{
    // indica se o cliente vai comer ou não no restaurante
    private boolean takeOut;
    
    // data de aniversario do cliente
    private String dataDeAniversario;
    
    // número de telefone do cliente
    private String telefone;
    
    // mesa na qual o cliente vai ocupar
    private Mesa mesa;
    
    // pedido vinculado ao cliente
    private final Pedido pedido;
    
    // tipo de pagamento escolhido pelo cliente
    private TiposPagamento pagamento;

    // Construtor da classe Cliente para o cliente que não vai comer no estabelecimento
    public Cliente(boolean takeOut, String cpf, String nome) {
        super(cpf, nome);
        this.takeOut = takeOut;
        this.pedido = new Pedido(this, 0, this.takeOut);
        this.mesa = null;
    }
    
    // Construtor da classe Cliente para o cliente que vai comer no estabelecimento
    public Cliente(boolean takeOut, Mesa mesa, String cpf, String nome) {
        super(cpf, nome);
        this.takeOut = takeOut;
        this.pedido = new Pedido(this, 0, this.takeOut);
        this.mesa = mesa;
    }
    
    // retorna o tipo de pagamento em formato de String
    public String getPagamento() {
        switch(pagamento) {
            case DINHEIRO: return "Dinheiro";
            case CARTAO_DE_CREDITO: return "Cartão de crédito";
            case PIX: return "Pix";
        }
        return null;
    }

    // define um novo tipo de pagamento
    public void setPagamento(TiposPagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    // retorna o pedido
    public Pedido getPedido() {
        return this.pedido;
    }
    
    // retorna a data de aniversário
    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    // define uma nova data de aniversário
    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    // retorna o número de telefone
    public String getTelefone() {
        return telefone;
    }

    // define um novo número de telefone
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // retorna se o cliente vai ou não comer no restaurante
    public boolean isTakeOut() {
        return takeOut;
    }
    
    // define se o cliente vai ou não comer no restaurante
    public void setTakeOut(boolean takeOut) {
        this.takeOut = takeOut;
    }

    // retorna a mesa ocupada pelo cliente
    public Mesa getMesa() {
        return mesa;
    }

    // define uma nova mesa ocupada pelo cliente
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
}
