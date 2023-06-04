package miqueias_fast_food;

/**
 *
 * @author guilherme
 */
public class ItemPedido {
    private int quantidade;
    private double subtotal;
    private final Item item;
    
    public ItemPedido(int quantidade, Item item) {
        this.quantidade = quantidade;
        this.item = item;
        this.subtotal = item.getPreco()*quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.subtotal = quantidade*item.getPreco();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Item getItem() {
        return item;
    }
}
