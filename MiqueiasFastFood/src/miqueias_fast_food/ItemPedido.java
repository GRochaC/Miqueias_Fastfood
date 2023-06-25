package miqueias_fast_food;

/**
 * @author guilherme
 * Classe auxiliar que indica a quantidade de um determinado item em um pedido
 */
public class ItemPedido {
    // quantidade do item no pedido
    private int quantidade;
    
    // subtotal do item no pedido
    private double subtotal;
    
    // item vinculado à classe
    private final Item item;
    
    // Construtor da classe ItemPedido
    public ItemPedido(int quantidade, Item item) {
        this.quantidade = quantidade;
        this.item = item;
        
        // define o subtotal do item no pedido
        this.subtotal = item.getPreco()*quantidade;
    }

    // retorna a quatidade do item no pedido
    public int getQuantidade() {
        return quantidade;
    }

    // defina uma nova quantidade para o item no pedido
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        
        // atualiza o subtotal do item no pedido
        this.subtotal = quantidade*item.getPreco();
    }

    // retorna o subtotal do item no pedido
    public double getSubtotal() {
        return subtotal;
    }

    // retorna o item vinculado à classe
    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return String.format("x%d %s : %.2f", this.getQuantidade(), this.getItem().toString(),
                this.getSubtotal());
    }
    
    
}
