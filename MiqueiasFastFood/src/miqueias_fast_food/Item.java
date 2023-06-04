package miqueias_fast_food;

import java.util.Objects;

/**
 *
 * @author guilherme
 */
public class Item {
    private String nome;
    private double preco;
    private boolean disponivel;
    private final float[] valoresNutricionais;
    private final TiposComida tipo;
    private String descricao;
    
    /*
    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.valoresNutricionais = new float[4];
    }
    
    public Item(String nome, double preco, float[] valoresNutricionais,
            TiposComida tipo) {
        this.nome = nome;
        this.preco = preco;
        this.valoresNutricionais = new float[4];
        System.arraycopy(valoresNutricionais, 0, this.valoresNutricionais, 0, 3);
        this.tipo = tipo;
    }
    */

    public Item(String nome, double preco, float[] valoresNutricionais,
            TiposComida tipo, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.valoresNutricionais = new float[4];
        System.arraycopy(valoresNutricionais, 0, this.valoresNutricionais, 0, 3);
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public float[] getValoresNutriciais() {
        return valoresNutricionais;
    }

    public void setValoresNutriciais(float[] valoresNutricionais) {
        System.arraycopy(valoresNutricionais, 0, this.valoresNutricionais, 0, 3);
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

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
