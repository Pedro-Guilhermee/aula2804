public class Funcionario implements Comparable<Funcionario> {
    private int id;
    private char categoria;
    private String nome;
    private String cargo;
    private char sexo;
    private int idade;
    private float salario;

    public Funcionario(int id, char categoria, String nome, String cargo, char sexo, int idade, float salario) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.cargo = cargo;
        this.sexo = sexo;
        this.idade = idade;
        this.salario = salario;
    }

    public int getId() { return id; }
    public char getCategoria() { return categoria; }
    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public char getSexo() { return sexo; }
    public int getIdade() { return idade; }
    public float getSalario() { return salario; }

    @Override
    public int compareTo(Funcionario outro) {
        if (this.id < outro.id) return -1;
        if (this.id > outro.id) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Cargo: " + cargo + 
               " | Cat: " + categoria + " | Sexo: " + sexo + 
               " | Idade: " + idade + " | Salário: R$ " + salario;
    }
}