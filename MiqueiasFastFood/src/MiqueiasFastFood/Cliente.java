package MiqueiasFastFood;

/**
 *
 * @author archago
 */
public class Cliente extends Pessoa {
    private String dataDeAniversario;
    private String telefone;

    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
