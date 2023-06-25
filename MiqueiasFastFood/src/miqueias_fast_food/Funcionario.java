package miqueias_fast_food;

/**
 * @author archago
 * Classe que representa o funcionário no sistema
 */
public class Funcionario extends Pessoa {
    // login do funcionário
    private String login;
    
    // senha do funcionário
    private String senha;
    
    // Construtor da classe Funcionario
    public Funcionario(String login, String senha, String cpf, String nome) {
        super(cpf, nome);
        this.login = login;
        this.senha = senha;
    }
    
    // retorna o login do funcionário
    public String getLogin() {
        return login;
    }

    // define um novo login para o funcionário
    public void setLogin(String login) {
        this.login = login;
    }

    // retorna a senha do funcionário
    public String getSenha() {
        return senha;
    }

    // define uma nova senha para o funcion
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
