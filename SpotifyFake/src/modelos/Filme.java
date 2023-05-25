package modelos;

public class Filme {

    private String titulo;
    private int ano;
    private int duracao;
    public Filme(String titulo, int ano, int duracao){
        this.titulo = titulo;
        this.ano = ano;
        this.duracao = duracao;
    }

    public Filme(FilmeJsonOmdb f){
        //Construtor alternativo para construir um Filme a partir dos seus dados convertidos do JSON do site
        this.titulo = f.title();
        this.ano = Integer.parseInt(f.year());
        this.duracao = Integer.parseInt(f.runtime().substring(0, 2));
        /*os getters de um record são nomeados a partir do próprio atributo: titulo(), e não getTitulo().
        Como boa prática, fazemos a conversão dos atributos vindos do JSON para os atributos que queremos aqui.
        Por exemplo: no JSON, runtime está como String e tem "min" no fim, e queremos passar ele pra um int duracao*/
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", duracao=" + duracao +
                '}';
    }
}
