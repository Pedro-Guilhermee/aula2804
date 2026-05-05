import java.util.Scanner;

public class TesteABB {
    public static void main(String[] args) {
        ABB<Funcionario> abb = new ABB<>();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("\n--- Sistema Mack Bem Vindo ---");
            System.out.println("1. Cadastrar funcionario");
            System.out.println("2. Mostrar todos os funcionarios");
            System.out.println("3. Mostrar gastos com salarios");
            System.out.println("4. Total de funcionarios por sexo");
            System.out.println("5. Quantidade por categoria");
            System.out.println("6. Funcionarios por idade mínima");
            System.out.println("7. Simular cadastro (20 registros)");
            System.out.println("8. Sair");
            System.out.print("Opção: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    cadastrar(abb, sc);
                    break;
                case 2:
                    abb.emOrdem2();
                    break;
                case 3:
                    System.out.printf("Total da Folha: R$ %.2f\n", abb.calcularSalarios());
                    break;
                case 4:
                    System.out.print("Sexo (M/F): ");
                    char s = sc.next().toUpperCase().charAt(0);
                    System.out.println("Total: " + abb.contarPorSexo(s));
                    break;
                case 5:
                    System.out.print("Categoria (P/O/H): ");
                    char c = sc.next().toUpperCase().charAt(0);
                    System.out.println("Total: " + abb.contarPorCategoria(c));
                    break;
                case 6:
                    System.out.print("Idade mínima: ");
                    int idMin = sc.nextInt();
                    abb.mostrarPorIdade(idMin);
                    break;
                case 7:
                    simular(abb);
                    System.out.println("Simulação concluída!");
                    break;
                case 8: 
                    System.out.print("Deseja realmente sair do sistema? (S/N): ");
                    char confirmar = sc.next().toUpperCase().charAt(0);
                    if (confirmar == 'S') {
                        System.out.println("Sistema encerrado.");
                    } else {
                        opc = 0;
                        System.out.println("Retornando ao menu...");
                    }
                    break;
            }
        } while (opc != 8);
    }

    private static void cadastrar(ABB<Funcionario> tree, Scanner sc) {
        System.out.print("ID: "); int id = sc.nextInt();
        System.out.print("Cat (P/O/H): "); char cat = sc.next().toUpperCase().charAt(0);
        sc.nextLine();
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Cargo: "); String cargo = sc.nextLine();
        System.out.print("Sexo (M/F): "); char sexo = sc.next().toUpperCase().charAt(0);
        System.out.print("Idade: "); int idade = sc.nextInt();
        System.out.print("Salário: "); float sal = sc.nextFloat();
        tree.inserir(new Funcionario(id, cat, nome, cargo, sexo, idade, sal));
    }

    private static void simular(ABB<Funcionario> tree) {
        int[] ids = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 85, 5, 15, 90, 95, 110};
        char[] categorias = {'P', 'O', 'H'};
        char[] sexos = {'M', 'F'};

        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            // Alterna sexo e categoria com base no índice para diversificar os dados
            char cat = categorias[i % 3]; 
            char sexo = sexos[i % 2];
            int idade = 20 + (id % 30);
            float sal = 2000 + (id * 10.5f);

            tree.inserir(new Funcionario(id, cat, "Funcionario " + id, "Cargo " + (i % 5), sexo, idade, sal));
        }
    }
}