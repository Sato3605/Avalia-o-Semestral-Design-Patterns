import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== MENU DE RELATORIOS =====");
            System.out.println("1 - Gerar Relatório Diário");
            System.out.println("2 - Gerar Relatório Semanal");
            System.out.println("3 - Gerar Relatório Emergencial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opçao: ");

            opcao = sc.nextInt();
            System.out.println();

            GeradorRelatorio gerador = null;

            switch (opcao) {
                case 1:
                    gerador = new GeradorRelatorioDiario();
                    break;
                case 2:
                    gerador = new GeradorRelatorioSemanal();
                    break;
                case 3:
                    gerador = new GeradorRelatorioEmergencial();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    continue;
                default:
                    System.out.println("Opção inválida!\n");
                    continue;
            }

            gerador.processarRelatorio();
            System.out.println();

        } while (opcao != 0);

        sc.close();
    }
}
