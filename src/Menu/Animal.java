package Menu;

public class Animal {
    String nome;
    String sobrenome;
    SexoAnimal sexo;
    double idade;
    double peso;
    String raca;
    public static final String NAO_INFORMADO = "Não informado";
    String endereco;
    public Animal() {
    }


    public Animal(String nome, String sobrenome, SexoAnimal sexo, double idade, double peso, String raca, String endereco) {
        this.nome = nome;
        this.sobrenome = aplicarpadrao(sobrenome);
        this.sexo = aplicarpadraoSexo(sexo);
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

    public String getEndereco() {
        return endereco;
    }

    private String aplicarpadrao(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return NAO_INFORMADO;
        }
        return valor;
    }
    private SexoAnimal aplicarpadraoSexo(SexoAnimal sexo){
        if(sexo ==  null){
            return SexoAnimal.NAO_INFORMADO;
        }
        return sexo;
    }
}
