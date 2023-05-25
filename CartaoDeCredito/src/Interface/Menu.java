package Interface;

import modelos.Cartao;
import modelos.Compra;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void exibirMenu(List<Compra> compras, Cartao cartao){
        System.out.println("Compras realizadas com sucesso:");
        System.out.println("\n" + compras);
        System.out.println("Saldo do cartão restante: R$" + cartao.getSaldo());
    }
}
