package modelos;

public class Compra {

    private String produto;
    private double preco;

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "produto:" + this.produto + "& preço: R$" + this.preco;
    }
}
