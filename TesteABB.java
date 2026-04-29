import java.util.Scanner;

public class TesteABB {
    public static void main(String[] args) {
        ABB<Funcionario> abb = new ABB<>();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("\nSistema MackBem Vindo");
            System.out.println("1. Cadastrar funcionario");
            System.out.println("2. Mostrar dados de todos os funcionarios cadastrados");
            System.out.println("7. Simular cadastro de funcionarios");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opcao: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Categoria (P/O/H): "); char cat = sc.next().toUpperCase().charAt(0);
                    sc.nextLine();
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("Cargo: "); String cargo = sc.nextLine();
                    System.out.print("Sexo (M/F): "); char sexo = sc.next().toUpperCase().charAt(0);
                    System.out.print("Idade: "); int idade = sc.nextInt();
                    System.out.print("Salario: "); float sal = sc.nextFloat();
                    abb.inserir(new Funcionario(id, cat, nome, cargo, sexo, idade, sal));
                    break;
                case 2:
                    abb.emOrdem2();
                    break;
                case 7:
                    simular(abb);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opc != 8);
    }

    private static void simular(ABB<Funcionario> tree) {
        tree.inserir(new Funcionario(50, 'P', "Ana", "Analista", 'F', 30, 5000));
        tree.inserir(new Funcionario(30, 'O', "Bruno", "Dev", 'M', 25, 4000));
        tree.inserir(new Funcionario(70, 'H', "Carla", "Gerente", 'F', 40, 9000));
        tree.inserir(new Funcionario(20, 'P', "Daniel", "Suporte", 'M', 22, 2500));
        tree.inserir(new Funcionario(40, 'O', "Eduarda", "Dev", 'F', 28, 4200));
        tree.inserir(new Funcionario(60, 'H', "Fabio", "Analista", 'M', 33, 5500));
        tree.inserir(new Funcionario(80, 'P', "Gisele", "Diretora", 'F', 45, 15000));
        tree.inserir(new Funcionario(10, 'O', "Heitor", "Estagiario", 'M', 20, 1500));
        tree.inserir(new Funcionario(25, 'H', "Irene", "RH", 'F', 35, 4800));
        tree.inserir(new Funcionario(35, 'P', "Joao", "Vendas", 'M', 29, 3000));
        tree.inserir(new Funcionario(45, 'O', "Karen", "Dev", 'F', 27, 4500));
        tree.inserir(new Funcionario(55, 'H', "Luis", "Dev", 'M', 31, 6000));
        tree.inserir(new Funcionario(65, 'P', "Mara", "Faxineira", 'F', 50, 2200));
        tree.inserir(new Funcionario(75, 'O', "Nuno", "Seguranca", 'M', 38, 3200));
        tree.inserir(new Funcionario(85, 'H', "Olivia", "Analista", 'F', 26, 5100));
        tree.inserir(new Funcionario(5, 'P', "Paulo", "Estagiario", 'M', 19, 1500));
        tree.inserir(new Funcionario(15, 'O', "Rosa", "Copa", 'F', 55, 2000));
        tree.inserir(new Funcionario(90, 'H', "Saulo", "Dev", 'M', 24, 4300));
        tree.inserir(new Funcionario(95, 'P', "Tatiane", "RH", 'F', 32, 4700));
        tree.inserir(new Funcionario(110, 'O', "Victor", "Vendas", 'M', 27, 3100));
    }
}