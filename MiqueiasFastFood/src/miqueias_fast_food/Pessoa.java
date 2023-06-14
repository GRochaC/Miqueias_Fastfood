package miqueias_fast_food;

/**
 * @author archago
 * Classe abstrata que representa uma pessoa no sistema
 */
public abstract class Pessoa {
    // cpf da pessoa
    protected String cpf;
    
    // nome da pessoa
    protected String nome;

    // Construtor da classe Pessoa
    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // retorna o cpf da pessoa
    public String getCpf() {
        return cpf;
    }

    // define um novo cpf para a pessoa
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // retorna o nome da pessoa
    public String getNome() {
        return nome;
    }

    // define um novo nome para a pessoa
    public void setNome(String nome) {
        this.nome = nome;
    }
}
