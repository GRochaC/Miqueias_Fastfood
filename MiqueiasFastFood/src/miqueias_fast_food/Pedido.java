package miqueias_fast_food;

import java.util.ArrayList;

/**
 * @author guilherme
 * Classe que representa o pedido do cliente no sistema
 */
public class Pedido {
    // identificador do pedido
    private final int idPedido;
    
    // indica se o cliente vai ou não comer no restaurante
    private boolean takeOut;
    
    // indica se o pedido tem desconto para as sobremesas caso seja aniversário do cliente no dia do pedido
    private boolean descontoSobremesa;

    // indica se o pedido tem desconto caso o cliente deseja pagar como dinheiro
    private boolean descontoDinheiro;
    
    // preço total do pedido
    private double total;
    
    // lista de itens pedidos que compõem o pedido
    private final ArrayList<ItemPedido> itensPedidos;
    
    // cliente vinculado com o pedido
    private final Cliente cliente;
    
    // Construtor da classe Pedido
    public Pedido(Cliente cliente, int idPedido, boolean takeOut) {
        this.itensPedidos = new ArrayList<>();
        this.cliente = cliente;
        this.idPedido = idPedido;
        this.takeOut = takeOut;
    }

    // retorna o identificador do pedido
    public int getIdPedido() {
        return idPedido;
    }

    // retorna se o cliente vai ou não comer no restaurante
    public boolean isTakeOut() {
        return takeOut;
    }

    // define se o cliente vai ou não comer no restaurante
    public void setTakeOut(boolean takeOut) {
        this.takeOut = takeOut;
    }

    // retorna se o pedido tem desconto para sobremesas
    public boolean isDescontoSobremesa() {
        return descontoSobremesa;
    }

    // define se o pedido tem ou não desconto para sobremesas
    public void setDescontoSobremesa(boolean descontoSobremesa) {
        this.descontoSobremesa = descontoSobremesa;
    }

    // retorna se o pedido tem desconto no pagamento em dinheiro
    public boolean isDescontoDinheiro() {
        return descontoDinheiro;
    }

    // define se o pedido tem ou não desconto no pagamento em dinheiro
    public void setDescontoDinheiro(boolean descontoDinheiro) {
        this.descontoDinheiro = descontoDinheiro;
    }

    // retorna o cliente vinculado com o pedido
    public Cliente getCliente() {
        return cliente;
    }

    // retorna o preço total do pedido
    public double getTotal() {
        total = 0;
        for(ItemPedido ip : itensPedidos) {
            total += ip.getSubtotal();
        } 
        return total;
    }
    
    // adicionar um item no pedido
    public boolean addItem(Item item, int quantidade) {
        for(int i = 0; i < itensPedidos.size(); i++) {
            ItemPedido ip_atual = itensPedidos.get(i);
            // se já houver o item no pedido:
            if(ip_atual.getItem().equals(item)) {
                ip_atual.setQuantidade(quantidade + ip_atual.getQuantidade());
                return true;
            }
        }
        // caso contr
        itensPedidos.add(new ItemPedido(quantidade, item));
        return true;
    }
    
    // remover um item do pedido
    public boolean delItem(Item item, int quantidade) {
        for(int i = 0; i < itensPedidos.size(); i++) {
            ItemPedido ip_atual = itensPedidos.get(i);
            if(ip_atual.getItem().equals(item)) {
                if(quantidade >= ip_atual.getQuantidade()) {
                    // remove o item do pedido
                    itensPedidos.remove(ip_atual);
                } else {
                    // atualiza a quantidade do item no pedido
                    ip_atual.setQuantidade(ip_atual.getQuantidade() - quantidade);
                }
                return true;
            }
        }
        
        // adicionar tratamento de erro aqui (?)
        
        return false;
    }
    
    // retorna a lista de itens pedidos no pedido
    public ArrayList<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }
    
}
