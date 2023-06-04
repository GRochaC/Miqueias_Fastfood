package miqueias_fast_food;

import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class Pedido {
    private double total;
    private final ArrayList<ItemPedido> itensPedidos;
    // private Cliente cliente;
    
    public Pedido(Item item, int quantidade) {
        ItemPedido itemPedido = new ItemPedido(quantidade, item);
        this.itensPedidos = new ArrayList<>(99);
        itensPedidos.add(itemPedido);
    }
    
    public double getTotal() {
        total = 0;
        for(ItemPedido ip : itensPedidos) {
            total += ip.getSubtotal();
        } 
        return total;
    }
    
    public void addItem(Item item, int quantidade) {
        for(int i = 0; i < itensPedidos.size(); i++) {
            ItemPedido ip_atual = itensPedidos.get(i);
            if(ip_atual.getItem().equals(item)) {
                ip_atual.setQuantidade(quantidade + ip_atual.getQuantidade());
                return;
            }
        }
        itensPedidos.add(new ItemPedido(quantidade, item));
    }
    
    public void delItem(Item item, int quantidade) {
        for(int i = 0; i < itensPedidos.size(); i++) {
            ItemPedido ip_atual = itensPedidos.get(i);
            if(ip_atual.getItem().equals(item)) {
                if(quantidade >= ip_atual.getQuantidade()) {
                    itensPedidos.remove(ip_atual);
                } else {
                    ip_atual.setQuantidade(ip_atual.getQuantidade() - quantidade);
                }
                return;
            }
        }
        System.out.println("Item não encontrado");
    }
    
    public ArrayList<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }
}
