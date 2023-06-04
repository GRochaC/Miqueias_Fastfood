package miqueias_fast_food;

import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class Pedido {
    private final int idPedido;
    private boolean takeOut;
    private boolean desconto;
    private double total;
    private final ArrayList<ItemPedido> itensPedidos;
    private final Cliente cliente;
    
    public Pedido(Cliente cliente, int idPedido, boolean takeOut) {
        this.itensPedidos = new ArrayList<>(99);
        this.cliente = cliente;
        this.idPedido = idPedido;
        this.takeOut = takeOut;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public boolean isTakeOut() {
        return takeOut;
    }

    public void setTakeOut(boolean takeOut) {
        this.takeOut = takeOut;
    }

    public boolean isDesconto() {
        return desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        total = 0;
        for(ItemPedido ip : itensPedidos) {
            total += ip.getSubtotal();
        } 
        return total;
    }
    
    public boolean addItem(Item item, int quantidade) {
        for(int i = 0; i < itensPedidos.size(); i++) {
            ItemPedido ip_atual = itensPedidos.get(i);
            if(ip_atual.getItem().equals(item)) {
                ip_atual.setQuantidade(quantidade + ip_atual.getQuantidade());
                return true;
            }
        }
        itensPedidos.add(new ItemPedido(quantidade, item));
        return true;
    }
    
    public boolean delItem(Item item, int quantidade) {
        for(int i = 0; i < itensPedidos.size(); i++) {
            ItemPedido ip_atual = itensPedidos.get(i);
            if(ip_atual.getItem().equals(item)) {
                if(quantidade >= ip_atual.getQuantidade()) {
                    itensPedidos.remove(ip_atual);
                    return false;
                } else {
                    ip_atual.setQuantidade(ip_atual.getQuantidade() - quantidade);
                }
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }
}
