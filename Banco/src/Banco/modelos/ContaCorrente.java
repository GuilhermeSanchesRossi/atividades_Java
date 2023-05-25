package Banco.modelos;

public class ContaCorrente extends Conta {

    private double rendimentoMes;
    private String tipoConta = "Corrente";

    public ContaCorrente(String nome) {
        super(nome);
        this.rendimentoMes = 0.12;
        this.saldo += rendimentoMes;
    }

    public String getTipoConta() {
        return tipoConta;
    }
}
