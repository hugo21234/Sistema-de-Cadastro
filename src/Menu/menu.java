package Menu;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.MathContext;

public class menu {

    static void main(String[] args) throws Exception {
        List<String> perguntas = new ArrayList<>();
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        boolean sistemaRodando = true;
        while (sistemaRodando) {
            try {
                System.out.printf("Digite a opção desejada: \n" +
                        "1-Cadastrar um novo pet\n" +
                        "2-Alterar os dados do pet cadastrado\n" +
                        "3-Deletar um pet \n" +
                        "4- Listar todos os pets cadastrados\n" +
                        "5- listar pets por algum criteiro\n" +
                        "6-Sair do programa\n"
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
                String escolha = scanner.nextLine();

                    if(escolha == null || escolha.trim().isEmpty() ){
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        continue;
                    }
                    if (!escolha.trim().matches("^[0-9]+$")) {
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        continue;
                    }
                    int escolhaInt = Integer.parseInt(escolha);
                    if (escolhaInt <= 0 || escolhaInt > 6 ) {
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
                        TipoAnimal tipoAnimal = TipoAnimal.valueOf(tipo);
                        // Pergunta 3: Sexo do animal
                        System.out.println(perguntas.get(2));
                        String sexoInput = scanner.nextLine();
                        SexoAnimal sexoAnimal = SexoAnimal.valueOf(sexoInput);

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
                        Math math = null;
                        double id = math.random() * 1000;
                        double idFormatado = math.round(id);
                        Animal animal = new Animal(idFormatado, nome, sobrenome, sexoAnimal, tipoAnimal, idade, peso, raca, endereco);
                        try {
                            cadastro.criarAnimal(animal);
                            System.out.println("Animal criado com sucesso!"+ cadastro.getAll());
                        } catch (ExececaoErrorCriacao e) {
                            System.out.println("Erro ao criar animal: " + e.getMessage());
                        }
                        break;
                    case "2":
                        System.out.println("Opção 2 selecionada: A Animal");
                        cadastro.getAll();
                        System.out.println("Qual deseja alterar?");
                        String escolhido = scanner.nextLine();

                        // Aqui você pode adicionar a lógica para deletar um animal
                        break;
                    case "3":
                        System.out.println("Opção 3 selecionada: Deletar Animal");
                        // Aqui você pode adicionar a lógica para buscar um animal
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            }
        }
    }

