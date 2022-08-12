package Application;
import java.io.PrintWriter;
import java.util.List;

public class Top250Movies {
	
	public static void main(String[] args) throws Exception {
		
		String apiKey = "k_80qjtmhb";

		//chamada da api devolvendo um json	
		String json = new ImdbApiClient(apiKey).getBody();
		
		//converter o json em um list de Movies
		List<Movie> movies = new ImdbMovieJsonParser(json).parse();
		
		//gerando HTML
		PrintWriter writer = new PrintWriter("content.html");		
		new HTMLGenerator(writer).generate(movies);
		writer.close();
		
		System.out.println("html pronto!");
		
	}
}
