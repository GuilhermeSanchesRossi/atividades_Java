package modelos;

public class Musica extends Audio {

    private String artista;
    private String album;

    public Musica(String nome, int duracao, int criterio, String artista, String album) {
        super(nome, duracao, criterio);
        this.album = album;
        this.artista = artista;
    }

    @Override
    public int classificar() {
        if(getTotalReproducoes() >= getCriterioClassificacao()){
            System.out.printf("Música %s muito bem avaliada!", getNome());
            return 10;
        } else {
            System.out.printf("Música %s mediana", getNome());
            return 8;
        }
    }

    @Override
    public String toString() {
        return "Musica{" +
                "nome='" + this.getNome() + '\'' +
                ", artista='" + artista + '\'' +
                ", album='" + album + '\'' +
                '}';
    }
}
