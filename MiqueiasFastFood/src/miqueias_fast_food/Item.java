package miqueias_fast_food;

import java.util.Objects;

/**
 * @author guilherme
 * Classe que representa um produto presente no cardápio/estoque do restaurante
 */

public class Item {
    // nome do item
    private String nome;
    
    // preço do item
    private double preco;
    
    // indica se o item está disponível ou não no cardápio
    private boolean disponivel;
    
    // Valor calórico do item
    private int valorNutricional;
    
    // tipo de comida do item: Cachorro-quente, Sanduíche, Bebida ou Sobremesa
    private final TiposComida tipo;
    
    // Construtor da classe Item
    public Item(String nome, double preco, int valorNutricional,
            TiposComida tipo) {
        this.nome = nome;
        this.preco = preco;
        this.valorNutricional = valorNutricional;
        this.tipo = tipo;
    }

    // retorna o nome do item
    public String getNome() {
        return this.nome;
    }

    // define um novo nome para o item
    public void setNome(String nome) {
        this.nome = nome;
    }

    // retorna o preço  do item
    public double getPreco() {
        return this.preco;
    }

    // define um novo preço para o item
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // retorna se o item está disponível ou não
    public boolean isDisponivel() {
        return this.disponivel;
    }

    // define se o item está disponível ou não
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Retorna o valor calórico do item
    public int getValorNutricial() {
        return this.valorNutricional;
    }

    // Redefine o valor calórico do item
    public void setValorNutricional(int valorNutricional) {
        this.valorNutricional = valorNutricional;
    }

    // retorna o tipo de comida do item em formato de String
    public String getTipo() {
        switch(tipo) {
            case SANDUICHE:
                return "Sanduíche";
            case CACHORRO_QUENTE:
                return "Cachorro-quente";
            case BEBIDA:
                return "Bebida";
            case SOBREMESA:
                return "Sobremesa";
        }
        return null;
    }

    // método toString() sobrescrito que retorna o nome do item
    @Override
    public String toString() {
        return this.getNome();
    }

    // métodos sobrescritos hashCode() e equals() para conferir igualdade entre itens a partir do nome
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }
}