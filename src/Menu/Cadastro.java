package Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;


public class Cadastro {
    protected static ArrayList<Animal> dados = new ArrayList<>();
    Path diretorio = Paths.get("C:\\Users\\Humberto Figueiredo\\IdeaProjects\\SistemaDeCadastro\\src\\Menu\\petsCadastrados");

    public void criarAnimal(Animal animal) throws ExececaoErrorCriacao, IOException {

        if (animal == null) {
            throw new ExececaoErrorCriacao("animal inexistente");
        }

        if (animal.getNome() == null || animal.getNome().trim().isEmpty()) {
            throw new ExececaoErrorCriacao("Nome vazio ou invalido");
        }
        if (!animal.getNome().matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            throw new ExececaoErrorCriacao("Nome contém caracteres especias");
        }
        if (animal.getSobrenome() == null || animal.getSobrenome().trim().isEmpty()) {

            throw new ExececaoErrorCriacao("Sobrenome vazio ou invalido");
        }
        if (!animal.getSobrenome().matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            throw new ExececaoErrorCriacao("Sobrenome contém caracteres especias");
        }
        if (animal.getPeso() > 60 || animal.getPeso() < 0.5) {
            throw new ExececaoErrorCriacao("Pet com Peso Obeso+ ou Ta morto");
        }
        if (animal.getIdade() > 20) {
            throw new ExececaoErrorCriacao("É uma Mumia é?");
        }

        if (animal.getRaca() == null || animal.getRaca().trim().isEmpty() || !animal.getRaca().matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            throw new ExececaoErrorCriacao("Raça Vazia ou Invalida");
        }

        dados.add(animal);

        String titulo = java.time.LocalDate.now() +"_"+animal.getNome().toUpperCase() + "_" + animal.getSobrenome().toUpperCase();

       try( FileWriter FileWriter = new FileWriter( diretorio+ "\\" + titulo+ ".txt")) {

           FileWriter.write("ID: " + animal.getId() + "\n" +
                   " Nome: " + animal.getNome() + "\n"
                   + " Sobrenome: " + animal.getSobrenome() + "\n"
                   + " Sexo: " + animal.getSexo() + "\n" +
                   " Idade: " + animal.getIdade() + "\n" +
                   " Peso: " + animal.getPeso() + " \n"
                   + " Raça: " + animal.getRaca() + "\n"
                   + "Tipo: " + animal.getTipo() + "\n"
                   + " Endereço: " + animal.getEndereco());
       }
      catch (Exception e){
           System.out.println("Erro ao criar arquivo: " + e.getMessage());
      }

        System.out.println(getAll());
    }

    public void deletarAnimal(String nome) {
        boolean encontrado = dados.removeIf(n -> n.getNome().equalsIgnoreCase(nome));

        if (!encontrado) {
            System.out.println("Pet não encontrado");
        } else {
            System.out.println("Pet Deletado Com Sucesso");
        }
    }

    ;

    public void alteraDados() {
    }

    public void buscarAnimal(String nome) {
        boolean encontrado = false;
        for (Animal n : dados) {
            if (n.getNome().equals(nome)) {
                encontrado = true;
                System.out.print("Animal" + " " + n.getNome() + " " + "Encontrado");

            }
        }
        if (!encontrado) {
            System.out.print("Animal não encontrado");
        }

    }

    public String getAll() {
        if (dados.isEmpty()) {
            String s = "dados vazios";
        }
        for (Animal n : dados) {

            System.out.println("ID: " + n.getId() + " Nome: " + n.getNome() + " Sobrenome: " + n.getSobrenome() + " Sexo: " + n.getSexo() + " Idade: " + n.getIdade() + " Peso: " + n.getPeso() + " Raça: " + n.getRaca() + " Endereço: " + n.getEndereco());

        }
        return "";
    }
}