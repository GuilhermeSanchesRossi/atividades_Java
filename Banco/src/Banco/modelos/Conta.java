package Banco.modelos;

public class Conta {
    protected double saldo;
    protected final String nome;

    public Conta(String nome) {
        this.nome = nome;
        this.saldo = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void addSaldo(double valor){
        this.saldo += valor;
    }

    public void subtraiSaldo(double valor){
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente!");
        } else{
            this.saldo -= valor;
        }
    }
}
