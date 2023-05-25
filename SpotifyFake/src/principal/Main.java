package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Filme;
import modelos.FilmeJsonOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*List<String> participantes = new ArrayList<>();
        participantes.add("Zé");
        participantes.add("Tião");
        Podcast falae = new Podcast("falae",100, 1000, "Guizao", participantes);


        for(int i = 0; i < 500; i++){
            falae.curtir();
        }
        falae.classificar();

        Musica ripscrew = new Musica("RIP Screw", 3, 5000, "Travis Scott", "Astroworld");

        for(int j = 0; j < 10000; j++){
            ripscrew.reproduzir();
        }
        ripscrew.classificar();

        ArrayList<Audio> listaDeEscutados = new ArrayList<>();
        listaDeEscutados.add(falae);
        listaDeEscutados.add(ripscrew);
        for(Audio item: listaDeEscutados) { //forEach
            System.out.println("\n" + item.toString());
            if(item instanceof Podcast){
                ((Podcast) item).exibePodcast();
                //é necessário fazer o type casting pois o compilador não reconhece que exibePodcast() é um método de item na lista
            }
        }

        //teste de variaveis de referencia:
        Musica byob = new Musica("BYOB", 2, 5000, "SOAD", "Toxicity");
        Musica m2 = byob;   //a variavel m2 nao vai "copiar" o objeto byob e criar um novo na memoria,
        m2.reproduzir();    //ele é uma referencia apontando para onde o objeto apontado por byob esta instanciado
        System.out.println(m2.getTotalReproducoes());

        //Ordenação de objetos
        listaDeEscutados.add(byob);
        Musica tooManyNights = new Musica("Too many nights", 3, 10000, "Don Toliver", "HEROES AND VILLIANS");
        listaDeEscutados.add(tooManyNights);
        ArrayList<String> participantesPodpah = new ArrayList<>();
        participantesPodpah.add("Mítico");
        participantesPodpah.add("Lula");
        Podcast podpah = new Podcast("Podpah!", 120, 1000000, "Igão", participantesPodpah);
        listaDeEscutados.add(podpah);

        System.out.println(listaDeEscutados);
        Collections.sort(listaDeEscutados);
        System.out.println(listaDeEscutados);*/

        /*Farei agora meu projeto se comunicar com um site de repositório de filmes,
        usando comunicação HTTP claro (as bbiliotecas de requisições HTTP já existem no Java padrão).
        Faremos de forma manual, utilizando uma biblioteca para tratamento de
        objetos JSON e importando ela como um arquivo .jar, pois ela não tá presente no pacote padrão do Java
        (arquivo com uma coleção de .java's já compilados, os .class). Para isso:
        File > Project Structure > Modules > Dependencies > botão + > incluir o .jar baixado
         */

        String busca = "Matrix";
        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=c762933a";
        //API do site OMDB para consulta de filmes. Método HTTP usado: GET

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResposta = response.body();
        System.out.println(jsonResposta);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        /*GsonBuilder() constrói um JSON da bilbioteca gson; setFieldNamingPolicy() é necessário
        porque as chaves do JSON que vem do site começam com letra maiúscula, o que não casa com
        o lowerCamelCase que usamos como boa prática de atributos*/

        FilmeJsonOmdb filme1Omdb = gson.fromJson(jsonResposta, FilmeJsonOmdb.class);
        /*o método fromJson() transforma um JSON numa classe, correspondendo as chaves do JSON com
        seus respectivos atributos na classe*/
        System.out.println(filme1Omdb);

        Filme filme1 = new Filme(filme1Omdb);
        System.out.println(filme1);
    }
}
