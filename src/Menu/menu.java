package Menu;


import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Menu.Cadastro;



public class menu {

    static void main(String[] args) throws Exception {
        List<String> perguntas = new ArrayList<>();
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        boolean sistemaRodando = true;
        while (sistemaRodando) {
            try {
                System.out.println("""
                        Digite a opção desejada:\s
                        1-Cadastrar um novo pet
                        2-Alterar os dados do pet cadastrado
                        3-Deletar um pet\s
                        4- Listar todos os pets cadastrados
                        5- listar pets por algum criteiro
                        6-Sair do programa
                        """
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String escolha = scanner.nextLine();

            if (escolha == null || escolha.trim().isEmpty()) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                continue;
            }
            if (!escolha.trim().matches("^[0-9]+$")) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                continue;
            }
            int escolhaInt = Integer.parseInt(escolha);
            if (escolhaInt <= 0 || escolhaInt > 6) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                continue;
            }
            switch (escolha) {
                case "1":
                    System.out.println("Opção 1 selecionada: Criar Animal");
                    BufferedReader br = new BufferedReader(new FileReader("formulario.txt"));
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        if (!linha.trim().isEmpty()) {
                            perguntas.add(linha);
                        }
                    }
                    br.close();
                    System.out.println("Iniciando cadastro");

                    // Pergunta 1: Nome e sobrenome
                    System.out.println(perguntas.get(0));
                    String nome = scanner.nextLine();

                    // Pergunta 2: Tipo do pet
                    System.out.println(perguntas.get(1));
                    String tipo = scanner.nextLine();
                    TipoAnimal tipoAnimal = TipoAnimal.valueOf(tipo.trim().toUpperCase());
                    // Pergunta 3: Sexo do animal
                    System.out.println(perguntas.get(2));
                    String sexoInput = scanner.nextLine();
                    SexoAnimal sexoAnimal = SexoAnimal.valueOf(sexoInput.trim().toUpperCase());

                    // Pergunta 4: Endereço e bairro
                    System.out.println(perguntas.get(3));
                    System.out.println(perguntas.get(4));
                    String numeroCasa = scanner.nextLine();
                    System.out.println(perguntas.get(5));
                    String cidade = scanner.nextLine();
                    System.out.println(perguntas.get(6));
                    String rua = scanner.nextLine();
                    String endereco = rua + " " + numeroCasa + " " + cidade;

                    // Pergunta 5: Idade aproximada
                    System.out.println(perguntas.get(7));
                    double idade = scanner.nextDouble();
                    scanner.nextLine();

                    // Pergunta 6: Peso aproximado
                    System.out.println(perguntas.get(8));
                    double peso = scanner.nextDouble();
                    scanner.nextLine();

                    // Pergunta 7: Raça do pet
                    System.out.println(perguntas.get(9));
                    String raca = scanner.nextLine();

                    // Separar nome e sobrenome
                    String[] nomeCompleto = nome.split(" ");
                    String nomeOnly = nomeCompleto.length > 0 ? nomeCompleto[0] : "";
                    String sobrenome = nomeCompleto.length > 1 ? nomeCompleto[1] : "";

                    int id = (int) (Math.random() * 9999) + 1;


                    Animal animal = new Animal(id, nomeOnly, sobrenome, sexoAnimal, tipoAnimal, idade, peso, raca, endereco);
                    try {
                        cadastro.criarAnimal(animal);
                        System.out.println("Animal criado com sucesso!");
                    } catch (ExececaoErrorCriacao e) {
                        System.out.println("Erro ao criar animal: " + e.getMessage());
                    }
                    break;

                case "2":   boolean idValido = true;
                    while (idValido){
                    String criterio1;
                    String criterio2;
                    String valor;
                    String tipoEscolhido1;
                    String valor2;
                    double idBusca;

                    System.out.println("Opção 2 selecionada: ");

                    System.out.println("QUal tipo de pet deseja buscar?");
                    tipoEscolhido1 = scanner.nextLine();

                    System.out.println("1- para 1 criterio ou 2- para 2 criterio");
                    String esc1 = scanner.nextLine();

                    if (esc1.equals("1")) {

                        System.out.println("Qual criterio deseja listar?" +
                                "temos nome, sobrenome, sexo, tipo, idade, peso e raca");
                        criterio1 = scanner.nextLine();

                        if (criterio1.equalsIgnoreCase("nome")) {
                            System.out.println("Digite o nome do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("nome", valor, tipoEscolhido1);


                        } else if (criterio1.equalsIgnoreCase("sobrenome")) {
                            System.out.println("Digite o sobrenome do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("sobrenome", valor, tipoEscolhido1);

                        } else if (criterio1.equalsIgnoreCase("sexo")) {
                            System.out.println("Digite o sexo do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("sexo", valor, tipoEscolhido1);

                        } else if (criterio1.equalsIgnoreCase("tipo")) {
                            System.out.println("Digite o tipo do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("tipo", valor, tipoEscolhido1);

                        } else if (criterio1.equalsIgnoreCase("idade")) {
                            System.out.println("Digite a idade do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("idade", valor, tipoEscolhido1);

                        } else if (criterio1.equalsIgnoreCase("peso")) {
                            System.out.println("Digite o peso do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("peso", valor, tipoEscolhido1);

                        } else if (criterio1.equalsIgnoreCase("raca")) {
                            System.out.println("Digite a raça do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("raca", valor, tipoEscolhido1);

                        } else {
                            System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                        }
                    }

                    if (esc1.equals("2")) {
                        System.out.println("Qual criterio deseja listar? 1-Nome e / ou sobrenome E IDADE ou 2-Idade E peso");
                        criterio2 = scanner.nextLine();


                        if (criterio2.equalsIgnoreCase("1")) {

                            System.out.println("Digite o nome/sobrenome do pet que deseja buscar:");
                            valor = scanner.nextLine();

                            System.out.println("Digite a idade do pet que deseja buscar:");
                            valor2 = scanner.nextLine();

                            cadastro.buscarAnimal("nome e idade", valor, valor2, tipoEscolhido1);

                        } else if (criterio2.equalsIgnoreCase("2")) {
                            System.out.println("Digite o Idade do pet que deseja buscar:");
                            valor = scanner.nextLine();

                            System.out.println("Digite o peso do pet que deseja buscar:");
                            valor2 = scanner.nextLine();

                            cadastro.buscarAnimal("Idade E peso", valor, valor2,tipoEscolhido1);
                        } else {
                            System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                        }
                    }

                        System.out.println("Qual id deseja alterar");
                        idBusca = Double.parseDouble(scanner.nextLine());
                        if (idBusca <= 0) {
                            System.out.println("ID inválido. Por favor, insira um ID válido.");
                            continue;
                        }


                    System.out.println("Qual criterio deseja alterar?" +
                            "temos nome, sobrenome,  idade, peso e raca");
                    String campoAlteracao = scanner.nextLine();

                    if(campoAlteracao.equalsIgnoreCase("sexo") || campoAlteracao.equalsIgnoreCase("tipo")){
                        System.out.println("Campo de alteração inválido. Por favor, escolha um campo válido para alteração.");
                        break;
                    }


                    System.out.println("Que valor ira usar para alterar");
                    String novoValor = scanner.nextLine();


                    cadastro.alteraDados(campoAlteracao, novoValor, idBusca);
                    idValido = false;

                }
                case "4": {

                    String criterio;
                    String criterio2;
                    String valor;
                    String tipoEscolhido;
                    String valor2;
                    String esc1;

                    System.out.println("QUal tipo de pet deseja buscar?");
                    tipoEscolhido = scanner.nextLine();
                    System.out.println("1- para 1 criterio ou 2- para 2 criterio");
                    esc1 = scanner.nextLine();
                    if (esc1.equals("1")) {
                        System.out.println("Qual criterio deseja listar?");
                        criterio = scanner.nextLine();

                        if (criterio.equalsIgnoreCase("nome")) {
                            System.out.println("Digite o nome do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("nome", valor, tipoEscolhido);

                        } else if (criterio.equalsIgnoreCase("sobrenome")) {
                            System.out.println("Digite o sobrenome do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("sobrenome", valor, tipoEscolhido);

                        } else if (criterio.equalsIgnoreCase("sexo")) {
                            System.out.println("Digite o sexo do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("sexo", valor, tipoEscolhido);

                        } else if (criterio.equalsIgnoreCase("tipo")) {
                            System.out.println("Digite o tipo do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("tipo", valor, tipoEscolhido);

                        } else if (criterio.equalsIgnoreCase("idade")) {
                            System.out.println("Digite a idade do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("idade", valor, tipoEscolhido);

                        } else if (criterio.equalsIgnoreCase("peso")) {
                            System.out.println("Digite o peso do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("peso", valor, tipoEscolhido);

                        } else if (criterio.equalsIgnoreCase("raca")) {
                            System.out.println("Digite a raça do pet que deseja buscar:");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal("raca", valor, tipoEscolhido);

                        } else {
                            System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                        }
                    }
                        if (esc1.equals("2")) {
                            System.out.println("Qual criterio deseja listar? Nome e / ou sobrenome E IDADE ou Idade E peso");
                            criterio2 = scanner.nextLine();
                            if (criterio2.equalsIgnoreCase("Nome e / ou sobrenome E IDADE")) {

                                System.out.println("Digite o nome/sobrenome do pet que deseja buscar:");
                                valor = scanner.nextLine();
                                System.out.println("Digite a idade do pet que deseja buscar:");
                                valor2 = scanner.nextLine();
                                cadastro.buscarAnimal("nome e idade", valor, valor2);

                            } else if (criterio2.equalsIgnoreCase("Idade E peso")) {

                                System.out.println("Digite o Idade do pet que deseja buscar:");
                                valor = scanner.nextLine();

                                System.out.println("Digite o peso do pet que deseja buscar:");
                                valor2 = scanner.nextLine();
                                cadastro.buscarAnimal("Idade E peso", valor, valor2);
                            }
                            else {
                                System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                            }

                        }
                    }

                }
            }
        }
    }
