import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class Top250Movies {
	
	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		
		//montando a request e recuperando o corpo da resposta
		String apiKey = "k_80qjtmhb";
		
		URI uri = new URI("https://imdb-api.com/en/API/Top250Movies/"+apiKey);
		
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(uri)
				.header("Content-Type", "application/json")
				.GET()
				.build();
		
		HttpClient cliente = HttpClient.newHttpClient();
		
		HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
		
		//pegando o corpo do json
		
		String json = response.body().substring(response.body().indexOf("[")+1, response.body().indexOf("]")+1);

		
		//pegando cada filme e jogando em um array
		String[] movies = parseJsonMovies(json);
		
		//pegando os títulos
		List<String> titles = parseTitles(movies);
		
		//pegando as url das imagens
		List<String> urlImages = parseUrlImages(movies);
		
		
		//imprimindo os valores obtidos
		System.out.println("\n TÍTULOS");
		titles.forEach(System.out::println);
		
		System.out.println("\n IMAGENS");
		urlImages.forEach(System.out::println);		
	
	}
	
	public static String[] parseJsonMovies(String json) {		
		String[] movies = json.split("},");
		
		for (int i = 0; i < movies.length; i++) {
			movies[i].replace("{", "");
		}	
		
		return movies;
		
	}
	
	public static List<String> parseTitles(String[] movies){
		
		List<String> titles = new ArrayList<>();
		for (int i = 0; i < movies.length; i++) {
			titles.add(movies[i].substring(movies[i].indexOf("title")+7, movies[i].indexOf("fullTitle")-2));
		}
		
		return titles;
	}
	
	public static List<String> parseUrlImages(String[] movies){
		
		List<String> urlImages = new ArrayList<>();
		for (int i = 0; i < movies.length; i++) {
			urlImages.add(movies[i].substring(movies[i].indexOf("image")+7, movies[i].indexOf("crew")-2));
		}
		
		return urlImages;
	}
	
	

}
