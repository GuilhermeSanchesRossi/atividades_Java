package modelos;

public record FilmeJsonOmdb(String title, String year, String runtime) {
    //Uma classe record é uma classe com atributos finais, não mutáveis
    //Criei ela para armazenar os campos do JSON que vem do site
}
