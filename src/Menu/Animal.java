package Menu;

public class Animal {
    String nome;
    String sobrenome;
    SexoAnimal sexo;
    double idade;
    double peso;
    String raca;

    public Animal() {
    }


    public Animal(String nome, String sobrenome, SexoAnimal sexo, double idade, double peso, String raca) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.idade = idade;
        this.raca = raca;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public SexoAnimal getSexo() {
        return sexo;
    }

    public double getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }
}
