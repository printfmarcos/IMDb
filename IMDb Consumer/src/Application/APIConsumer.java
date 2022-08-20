package Application;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Client.ImdbApiClient;
import Client.MarvelApiClient;
import JsonParser.ImdbMovieJsonParser;
import JsonParser.JsonParser;
import JsonParser.MarvelSerieJsonParser;
import Utils.HTMLGenerator;
import model.Content;
import model.Movie;

public class APIConsumer {
	
	public static void main(String[] args) throws Exception {
		
//		/**
//		 * chamando a api Imdb
//		 */
//		String apiKeyIMDB = "k_80qjtmhb";
//		String apiKeyMarvel = "8c8a40c9002fa454b2022facd1adec3a";
//
//		//chamada da api devolvendo um json	
//		String json = new ImdbApiClient(apiKeyIMDB).getBody();
//		
//		//converter o json em um list de Movies
//		List<Movie> movies = (List<Movie>) new ImdbMovieJsonParser(json).parse();
//		
//		//gerando HTML
//		PrintWriter writer = new PrintWriter("content.html");		
//		new HTMLGenerator(writer).generate(movies);
//		writer.close();
//		
//		System.out.println("html pronto!");
		
		
		/**
		 * chamando a Api da Marvel
		 */
		String apiKey = "8c8a40c9002fa454b2022facd1adec3a";
		String privateKey = "8ecb6676071729ab74d91f75f564a623f8ba6dc4";
		
		//chamando a api e devolvendo um json
		String jsonSeries = new MarvelApiClient(apiKey, privateKey).getBody();
		
		JsonParser jsonParser = new MarvelSerieJsonParser(jsonSeries);
		List<? extends Content> contentList = jsonParser.parse();
//		List<? extends Content> series = jsonParser.parse();
		
		//metodo usado para juntar os filmes e as series em uma lista
//		contentList = Stream.of(series, contentList).flatMap(Collection::stream).collect(Collectors.toList());
		//ordenando a lista
		Collections.sort(contentList, Comparator.comparing(Content::year));
		
		//gerando o html
		PrintWriter writer = new PrintWriter("content.html");
		new HTMLGenerator(writer).generate(contentList);
		writer.close();
		
	}
}
