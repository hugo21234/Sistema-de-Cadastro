package Menu;


import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




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
                case "1": {
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
                }
                case "2": {
                    boolean idValido = true;
                    while (idValido) {
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
                            System.out.println("Qual valor deseja buscar?");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal(criterio1, valor, tipoEscolhido1);


                        } else if (esc1.equals("2")) {

                            System.out.println("Qual criterio deseja listar? 1-Nome e / ou sobrenome E IDADE ou 2-Idade E peso");
                            criterio2 = scanner.nextLine();

                            if (criterio2.equalsIgnoreCase("2")) {
                                criterio2 = "idade E peso";
                            } else if (criterio2.equalsIgnoreCase("1")) {
                                criterio2 = "nome e idade";
                            }else {
                                System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                                continue;
                            }

                            System.out.println("Qual valor deseja buscar para o primeiro criterio?");
                            valor = scanner.nextLine();
                            System.out.println("Qual valor deseja buscar para o segundo criterio?");
                            valor2 = scanner.nextLine();
                            cadastro.buscarAnimal(criterio2, valor, valor2, tipoEscolhido1);


                        } else {
                            System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                            continue;
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

                        if (campoAlteracao.equalsIgnoreCase("sexo") || campoAlteracao.equalsIgnoreCase("tipo")) {
                            System.out.println("Campo de alteração inválido. Por favor, escolha um campo válido para alteração.");
                            continue;
                        }


                        System.out.println("Que valor ira usar para alterar");
                        String novoValor = scanner.nextLine();


                        cadastro.alteraDados(campoAlteracao, novoValor, idBusca);
                        idValido = false;
                    }
                    break;
                }
                case "3": {
                    boolean idValido = true;
                    while (idValido) {
                        String criterio1;
                        String criterio2;
                        String valor;
                        String tipoEscolhido1;
                        String valor2;
                        double idBusca;

                        System.out.println("QUal tipo de pet deseja buscar?");
                        tipoEscolhido1 = scanner.nextLine();

                        System.out.println("1- para 1 criterio ou 2- para 2 criterio");
                        String esc1 = scanner.nextLine();

                        if (esc1.equals("1")) {

                            System.out.println("Qual criterio deseja listar?" +
                                    "temos nome, sobrenome, sexo, tipo, idade, peso e raca");
                            criterio1 = scanner.nextLine();
                            System.out.println("Qual valor deseja buscar?");
                            valor = scanner.nextLine();
                            cadastro.buscarAnimal(criterio1, valor, tipoEscolhido1);


                        } else if (esc1.equals("2")) {

                            System.out.println("Qual criterio deseja listar? 1-Nome e / ou sobrenome E IDADE ou 2-Idade E peso");
                            criterio2 = scanner.nextLine();

                            if (criterio2.equalsIgnoreCase("2")) {
                                criterio2 = "idade E peso";
                            } else if (criterio2.equalsIgnoreCase("1")) {
                                criterio2 = "nome e idade";
                            } else {
                                System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                                continue;
                            }

                            System.out.println("Qual valor deseja buscar para o primeiro criterio?");
                            valor = scanner.nextLine();
                            System.out.println("Qual valor deseja buscar para o segundo criterio?");
                            valor2 = scanner.nextLine();
                            cadastro.buscarAnimal(criterio2, valor, valor2, tipoEscolhido1);


                        } else {
                            System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                            continue;
                        }

                        System.out.println("Qual id deseja deletar");
                        idBusca = Double.parseDouble(scanner.nextLine());

                        if (idBusca <= 0) {
                            System.out.println("ID inválido. Por favor, insira um ID válido.");
                            continue;
                        }


                        System.out.println("deseja deletar o pet: "+ idBusca+"? 1- Sim ou 2- Não");
                        String escolhaDeletar = scanner.nextLine();
                        if (escolhaDeletar.equals("1")) {
                        cadastro.deletarAnimal(idBusca);
                            idValido = false;
                    } else if (escolhaDeletar.equals("2")) {
                        System.out.println("Operação de exclusão cancelada. O pet não será deletado");
                        }
                        idValido = false;
                    }
                        break;
                }
                case "4": {
                    List <Animal> lista = Cadastro.getAll();
                    for (Animal n : lista){
                        System.out.println(n.getNome() +
                                " " + n.getSobrenome()
                                + " " + n.getSexo() + " "
                                + n.getIdade() + " "
                                + n.getPeso() + " "
                                + n.getRaca() + " "
                                + n.getEndereco());
                    }
                    break;
                }
                case "5": {

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

                        System.out.println("Qual criterio deseja listar?" +
                                "temos nome, sobrenome, sexo, tipo, idade, peso e raca");
                        criterio = scanner.nextLine();
                        System.out.println("Qual valor deseja buscar?");
                        valor = scanner.nextLine();
                        cadastro.buscarAnimal(criterio, valor, tipoEscolhido);


                    }  else if (esc1.equals("2")) {

                        System.out.println("Qual criterio deseja listar? 1-Nome e / ou sobrenome E IDADE ou 2-Idade E peso");
                        criterio2 = scanner.nextLine();

                        if (criterio2.equalsIgnoreCase("2")){
                            criterio2 = "idade E peso";
                        } else if (criterio2.equalsIgnoreCase("1")) {
                            criterio2 = "nome e idade";
                        } else {
                            System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                            continue;
                        }

                        System.out.println("Qual valor deseja buscar para o primeiro criterio?");
                        valor = scanner.nextLine();

                        System.out.println("Qual valor deseja buscar para o segundo criterio?");
                        valor2 = scanner.nextLine();

                        cadastro.buscarAnimal(criterio2, valor, valor2, tipoEscolhido);


                    } else {
                        System.out.println("Criterio inválido. Por favor, escolha um criterio válido.");
                        continue;
                    }
                break;
                }
                case "6" : {
                    sistemaRodando = false;
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                }
                 default: {
                     System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                     break;
                 }
                }
            }
        }
    }
