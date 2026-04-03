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

    public void buscarAnimal(String criterio, String valor ) {
        boolean encontrado = false;
        if (criterio.equalsIgnoreCase("nome")) {
            for (Animal n : dados) {
                if (n.getNome().equals(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getNome() + " " + "Encontrado");

                }
            }
        } else if (criterio.equalsIgnoreCase("sobrenome")) {
            for (Animal n : dados) {
                if (n.getSobrenome().equals(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getSobrenome() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("raca")) {
            for (Animal n : dados) {
                if (n.getRaca().equals(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getRaca() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("tipo")) {
            for (Animal n : dados) {
                if (n.getTipo().toString().equalsIgnoreCase(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getTipo() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("sexo")) {
            for (Animal n : dados) {
                if (n.getSexo().toString().equalsIgnoreCase(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getSexo() + " " + "Encontrado");

                }

            }

        } else if (criterio.equalsIgnoreCase("idade")) {
            for (Animal n : dados) {
                if (Double.toString(n.getIdade()).equals(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getIdade() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("peso")) {
            for (Animal n : dados) {
                if (Double.toString(n.getPeso()).equals(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getPeso() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("endereco")) {
            for (Animal n : dados) {
                if (n.getEndereco().equalsIgnoreCase(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getEndereco() + " " + "Encontrado");

                }

            }

        } else if (criterio.equalsIgnoreCase("id")) {
            for (Animal n : dados) {
                if (Double.toString(n.getId()).equals(valor)) {
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getId() + " " + "Encontrado");

                }

            }
        } else {
            System.out.println("Criterio Invalido");
        }
        if (!encontrado) {
            System.out.println("Animal Não Encontrado");
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