package Interface;

import modelos.Cartao;
import modelos.Compra;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Cartao cartaoDeCredito = new Cartao("Crédito", 1000.0);

        int opcao = 1;
        Scanner scan = new Scanner(System.in);

        while (opcao == 1) {
            Compra compra = new Compra();
            System.out.println("Entre com o produto:");
            String produto = scan.next();
            compra.setProduto(produto);
            System.out.println("Entre com o preço:");
            double preco = scan.nextDouble();
            compra.setPreco(preco);
            cartaoDeCredito.adicionarCompra(compra);
            if(compra.getPreco() > cartaoDeCredito.getSaldo()) {
                System.out.println("Saldo insuficiente!");
                cartaoDeCredito.removeCompra(compra);
            } else {
                cartaoDeCredito.debitarSaldo(compra.getPreco());
            }
            System.out.println("Entre com 1 se quiser continuar ou 0 para encerrar:");
            opcao = scan.nextInt();
            while(opcao < 0 || opcao > 1) {
                System.out.println("Opção inválida!");
                System.out.println("Entre com 1 se quiser continuar ou 0 para encerrar:");
                opcao = scan.nextInt();
            }
            if (opcao == 0) {
                Menu.exibirMenu(cartaoDeCredito.getCompras(), cartaoDeCredito);
            }
        }

        scan.close();
    }
}
