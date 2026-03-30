package Menu;

import java.util.ArrayList;

public class Cadastro {
        ArrayList<Animal> dados = new ArrayList<>();

   public void criarAnimal(Animal animal) throws ExececaoErrorCriacao {

       if (animal == null){
           throw new ExececaoErrorCriacao("animal inexistente");
       }

       if(animal.getNome() == null || animal.getNome().trim().isEmpty()) {
          throw new ExececaoErrorCriacao("Nome vazio ou invalido");
      }
       if (!animal.getNome().matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
           throw new ExececaoErrorCriacao("Nome contém caracteres especias");
       }
       if(animal.getSobrenome() == null || animal.getSobrenome().trim().isEmpty()) {
           throw new ExececaoErrorCriacao("Sobrenome vazio ou invalido");
       }
       if (!animal.getSobrenome().matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
           throw new ExececaoErrorCriacao("Sobrenome contém caracteres especias");
       }
       if (animal.getPeso() > 60 || animal.getPeso() < 0.5 ) {
           throw new ExececaoErrorCriacao("Pet com Peso Obeso+ ou Ta morto");
       }
       if (animal.getIdade() > 20 ) {
           throw new ExececaoErrorCriacao("É uma Mumia é?");
       }

       if(animal.getRaca() == null || animal.getRaca().trim().isEmpty() || !animal.getRaca().matches("^[a-zA-ZÀ-ÿ\\s]+$")){
           throw new ExececaoErrorCriacao("Raça Vazia ou Invalida");
       }
       dados.add(animal);
        }

   public void deletarAnimal(String nome){
            boolean encontrado = dados.removeIf(n -> n.getNome().equalsIgnoreCase(nome));

            if(!encontrado){
                System.out.println("Pet não encontrado");
           }
            else{
                System.out.println("Pet Deletado Com Sucesso");
       }
  };

   public void buscarAnimal(String nome){
        boolean encontrado = false;
        for(Animal n : dados){
            if (n.getNome().equals(nome)) {
                encontrado = true;
                System.out.print("Produto" + " " + n.getNome() + " " + "Encontrado");

            }
        }
       if(!encontrado){
           System.out.print("Produto não encontrado");
       }

    }

   }

