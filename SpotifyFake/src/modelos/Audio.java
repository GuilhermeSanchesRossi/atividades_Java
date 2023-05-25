package modelos;

public class Audio implements Comparable<Audio> {
    //a implementação torna a classe ordenável
    private String nome;
    private int duracaoTotal;
    private int totalReproducoes = 0;
    private int totalCurtidas = 0;
    private int classificacao = 0;
    private int criterioClassificacao;

    public Audio(String nome, int duracao, int criterio) {
        this.nome = nome;
        this.duracaoTotal = duracao;
        this.criterioClassificacao = criterio;
    }

    public String getNome() {
        return nome;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public void curtir() {
        this.totalCurtidas++;
    }

    public void reproduzir() {
        this.totalReproducoes++;
    }

    public int getCriterioClassificacao() {
        return criterioClassificacao;
    }

    public int classificar() {
        if(this.totalCurtidas >= this.criterioClassificacao){
            System.out.println("Faixa bastante ouvida!");
            return 10;
        } else {
            System.out.println("Faixa em expansão");
            return 7;
        }
    }

    @Override
    public int compareTo(Audio outroAudio) {
        return this.getNome().toLowerCase().compareTo(outroAudio.getNome().toLowerCase());
        //Critério de ordenação será o alfabético, pelo nome do Audio.
        //Importante adicionar o método toLowerCase() de String, pois sem ele,
        //a ordenação acontece separada pra letras maiúsculas e minúsculas
    }

    @Override
    public String toString() {
        return "Audio{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
