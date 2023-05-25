package modelos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cartao {

    private String tipoCartao;
    private double limiteCartao;

    private double saldo;
    private List<Compra> compras;

    public Cartao(String tipoCartao, double limiteCartao) {
        this.tipoCartao = tipoCartao;
        this.limiteCartao = limiteCartao;
        this.saldo = limiteCartao;
        compras = new ArrayList<>();
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public double getLimiteCartao() {
        return limiteCartao;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitarSaldo(double valor){
        this.saldo -= valor;
    }

    public void adicionarCompra(Compra compra){
        this.compras.add(compra);
        this.compras.sort(Comparator.comparing(Compra::getPreco));
        //Não foi necessário que a classe Compra implementasse a interface Comparable, só se eu quisesse mudar a rega de ordenagem
    }

    public void removeCompra(Compra compra){
        this.compras.remove(compra);
    }
}
