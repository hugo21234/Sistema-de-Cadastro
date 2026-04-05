package Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    protected static List<Animal> dados = new ArrayList<>();
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

        String titulo = java.time.LocalDate.now() + "_" + animal.getNome().toUpperCase() + "_" + animal.getSobrenome().toUpperCase();

        try (FileWriter FileWriter = new FileWriter(diretorio + "\\" + titulo + ".txt")) {

            FileWriter.write("ID: " + animal.getId() + "\n" +
                    " Nome: " + animal.getNome() + "\n"
                    + " Sobrenome: " + animal.getSobrenome() + "\n"
                    + " Sexo: " + animal.getSexo() + "\n" +
                    " Idade: " + animal.getIdade() + "\n" +
                    " Peso: " + animal.getPeso() + " \n"
                    + " Raça: " + animal.getRaca() + "\n"
                    + "Tipo: " + animal.getTipo() + "\n"
                    + " Endereço: " + animal.getEndereco());
        } catch (Exception e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    public void deletarAnimal(double id) {
        boolean encontrado = dados.removeIf(n -> n.getId() == id);

        if (!encontrado) {
            System.out.println("Pet não encontrado");
        } else {
            System.out.println("Pet Deletado Com Sucesso");
        }
    }

    public void alteraDados(String criterio , String valorS, double Id) {
        boolean encontrado = false;
        if (criterio == null || valorS == null || criterio.trim().isEmpty() || valorS.trim().isEmpty()) {
            System.out.println("Criterio ou valor inválido");
            return;
        }
        if (criterio.equalsIgnoreCase("nome")) {
            for (Animal n : dados) {
                if (n.getId() == Id) {
                    n.setNome(valorS);
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getNome() + " " + "Encontrado");

                }
            }
        } else if (criterio.equalsIgnoreCase("sobrenome")) {
            for (Animal n : dados) {
                if (n.getId() == Id) {
                    n.setSobrenome(valorS);
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getSobrenome() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("raca")) {
            for (Animal n : dados) {
                if (n.getId() == Id) {
                    n.setRaca(valorS);
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getRaca() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("idade")) {
            for (Animal n : dados) {
                if (n.getId() == Id) {
                    n.setIdade(Double.parseDouble(valorS));
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getIdade() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("peso")) {
            for (Animal n : dados) {
                if (n.getId() == Id) {
                    n.setPeso(Double.parseDouble(valorS));
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getPeso() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("endereco")) {
            for (Animal n : dados) {
                if (n.getId() == Id) {
                    n.setEndereco(valorS);
                    encontrado = true;
                    System.out.print("Animal" + " " + n.getEndereco() + " " + "Encontrado");

                }

            }
        } else {
            System.out.println("Criterio Invalido");
        }
        if (!encontrado) {
            System.out.println("Animal Não Encontrado");
        }
    }

    public void buscarAnimal(String criterio, String valor, String petTipo) {
        boolean encontrado = false;

        if (criterio == null || valor == null || petTipo == null || criterio.trim().isEmpty() || valor.trim().isEmpty() || petTipo.trim().isEmpty()) {
            System.out.println("Criterio ou valor inválido");
            return;
        }

        TipoAnimal tipoFiltro;
        try {
            tipoFiltro = TipoAnimal.valueOf(petTipo.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de pet inválido");
            return;
        }

        if (criterio.equalsIgnoreCase("nome")) {

            for (Animal n : dados) {
                if (n.getNome().toUpperCase().contains(valor.toUpperCase()) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                        System.out.println("Id"+" "+ n.getId()+ "Animal" + " " + n.getNome() + " " + "Encontrado");
                }
            }

        } else if (criterio.equalsIgnoreCase("sobrenome")) {
            for (Animal n : dados) {
                if (n.getSobrenome().toUpperCase().contains(valor.toUpperCase()) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Id: " + n.getId() +" "+"Animal" + " " + n.getSobrenome() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("raca")) {
            for (Animal n : dados) {
                if (n.getRaca().equals(valor) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Id: " + n.getId() +" "+"Animal" + " " + n.getRaca() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("tipo")) {
            for (Animal n : dados) {
                if (n.getTipo().toString().equalsIgnoreCase(valor) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Id: " + n.getId() +" "+"Animal" + " " + n.getTipo() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("sexo")) {
            for (Animal n : dados) {
                if (n.getSexo().toString().equalsIgnoreCase(valor) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Id: " + n.getId() +" "+"Animal" + " " + n.getSexo() + " " + "Encontrado");

                }

            }

        } else if (criterio.equalsIgnoreCase("idade")) {
            for (Animal n : dados) {
                if (Double.toString(n.getIdade()).equals(valor) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Id: " + n.getId() +" "+"Animal" + " " + n.getIdade() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("peso")) {
            for (Animal n : dados) {
                if (Double.toString(n.getPeso()).equals(valor) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Id: " + n.getId() +" "+"Animal" + " " + n.getPeso() + " " + "Encontrado");

                }

            }
        } else if (criterio.equalsIgnoreCase("endereco")) {
            for (Animal n : dados) {
                if (n.getEndereco().equalsIgnoreCase(valor) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Id: " + n.getId() +" "+"Animal" + " " + n.getEndereco() + " " + "Encontrado");

                }

            }

        } else if (criterio.equalsIgnoreCase("id")) {
            for (Animal n : dados) {
                if (Double.toString(n.getId()).equals(valor) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Id: " + n.getId() +" "+"Animal" + " " + n.getId() + " " + "Encontrado");

                }

            }
        } else {
            System.out.println("Criterio Invalido");
        }
        if (!encontrado) {
            System.out.println("Animal Não Encontrado");
        }
    }

    public void buscarAnimal(String criterio, String valor1, String valor2, String tipoPet) {
        boolean encontrado = false;
        if (criterio == null || valor1 == null || valor2 == null || tipoPet == null || criterio.trim().isEmpty() || valor1.trim().isEmpty() || valor2.trim().isEmpty() || tipoPet.trim().isEmpty()) {
            System.out.println("Criterio ou valor inválido");
            return;
        }

        TipoAnimal tipoFiltro;
        try {
            tipoFiltro = TipoAnimal.valueOf(tipoPet.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de pet inválido");
            return;
        }

        if (criterio.equalsIgnoreCase("nome e idade")) {
            for (Animal n : dados) {
                if (n.getNome().toUpperCase().contains(valor1.toUpperCase()) && Double.toString(n.getIdade()).equals(valor2) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Nome: " + "\u001B[1m" + n.getNome() + "\u001B[0m" + " "
                            + "tipo: "
                            + n.getTipo() +
                            "e Idade"
                            + " "
                            + n.getIdade() +
                            " " +
                            " endereço"+
                            n.getEndereco()+
                            " "+
                            n.getIdade()+
                            " "+
                            n.getPeso()+
                            " "+
                            n.getRaca()+
                            " "+
                            "Encontrado");
                }
            }
        } else if (criterio.equalsIgnoreCase("Idade E peso")) {
            for (Animal n : dados) {
                if (Double.toString(n.getIdade()).equals(valor1) && Double.toString(n.getPeso()).equals(valor2) && n.getTipo() == tipoFiltro) {
                    encontrado = true;
                    System.out.print("Nome: " + "\u001B[1m" + n.getNome() + "\u001B[0m" + " "
                            + "tipo: "
                            + n.getTipo() +
                            "e Idade"
                            + " "
                            + n.getIdade() +
                            " " +
                            " endereço"+
                            n.getEndereco()+
                            " "+
                            n.getIdade()+
                            " "+
                            n.getPeso()+
                            " "+
                            n.getRaca()+
                            " "+
                            "Encontrado");
                }
            }
        }

        if (!encontrado) {
            System.out.println("Animal Não Encontrado");
        }
    }

    public  static List<Animal> getAll() {
        return java.util.Collections.unmodifiableList(dados);
    }
}

