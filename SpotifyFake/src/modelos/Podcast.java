package modelos;

import java.util.List;

public class Podcast extends Audio {

    private String anfitriao;
    private List<String> participantes;

    public Podcast(String nome, int duracao, int criterio, String anfitriao, List<String> participantes) {
        super(nome, duracao, criterio);
        this.anfitriao = anfitriao;
        this.participantes = participantes;
    }

    public void exibePodcast() {
        System.out.printf("""
                Elenco do %s:
                Anfitrião: %s,
                Participantes: %s
                """, getNome(), this.anfitriao, this.participantes);
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "nome='" + this.getNome() + '\'' +
                ", anfitriao='" + anfitriao + '\'' +
                ", participantes=" + participantes +
                '}';
    }
}
