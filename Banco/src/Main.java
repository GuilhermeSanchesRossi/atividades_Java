import Banco.modelos.Conta;
import Banco.modelos.ContaCorrente;

import java.util.Scanner;

public class Main {

    public static void menu(String name, String tipoConta, double valor){   //a ordem dos parâmetros passados importa
        System.out.printf("""
                _____________________________________________________
                Olá, %s!
                Tipo de conta: %s
                Saldo momentâneo = %.2f
                
                O que deseja realizar? (entre com o número da opção)
                1- Exibir saldo
                2- Adicionar saldo
                3- Realizar transferência
                4- Sair
                _____________________________________________________
                """, name, tipoConta, valor);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ContaCorrente account = new ContaCorrente("Zado");

        while(true){

            menu(account.getNome(), account.getTipoConta(), account.getSaldo());
            int opcao = scan.nextInt();

            switch (opcao) {
                case 1 -> System.out.printf("Saldo no momento: %.2f \n", account.getSaldo());
                case 2 -> {
                    System.out.println("Entre com a quantia a ser depositada:");
                    double quantia = scan.nextDouble();
                    account.addSaldo(quantia);
                }
                case 3 -> {
                    System.out.println("Entre com a quantia a ser transferida:");
                    double valor = scan.nextDouble();
                    account.subtraiSaldo(valor);
                }
                case 4 -> System.out.println("Exit com sucesso.");
                default -> System.out.println("Opção inválida!");
            }
            if(opcao == 4)
                break;
        }

        scan.close();
    }
}
