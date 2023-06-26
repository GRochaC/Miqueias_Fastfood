/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miqueias_fast_food;
import java.io.*;
import java.util.*;
/**
 *
 * @author archago
 */
public class CarregarFuncionario {
    private static final String funcionarioDir = "funcionarios.txt";
    private static ArrayList<Funcionario> tabelaFuncionarios;

    public static ArrayList<Funcionario> getTabelaFuncionarios() {
        return tabelaFuncionarios;
    }    
    
    public static void FetchWorkers(){
        tabelaFuncionarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(funcionarioDir))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 4) {
                    String login = data[0].trim();
                    String senha = data[1].trim();
                    String cpf = data[2].trim();
                    String nome = data[3].trim();
                    Funcionario worker = new Funcionario(login, senha, cpf, nome);
                    tabelaFuncionarios.add(worker);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    
    public static void RegistraFuncionario(String l, String s, String c, String nome){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(funcionarioDir, true))) {
            String line = l + ";" + s + ";" + c + ";" + nome;
            writer.newLine();
            writer.write(line);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void EditarFuncionario(String cLogin, String l, String senha, String nome, String cpf){
        
        try {
        File file = new File(funcionarioDir);
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            if (data.length == 4 && data[0].equals(cLogin)) {
                line = l + ";" + senha + ";" + cpf + ";" + nome;
            }
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();

        if (file.exists()) {
            file.delete();
        }
        tempFile.renameTo(file);
    } catch (IOException e) {
        e.printStackTrace();
        
    }
    
}
 
    public static void DeletarFuncionario(String login) {
    try {
        File file = new File(funcionarioDir);
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            if (data.length == 4 && data[0].equals(login)) {
                continue; // Skip writing the line if the login matches
            }
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();

        if (file.exists()) {
            file.delete();
        }
        tempFile.renameTo(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    
}