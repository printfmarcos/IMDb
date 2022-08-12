package Application;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbApiClient {
	
	private String apiKey;

	public ImdbApiClient(String apiKey) {
		this.apiKey = apiKey;
	}	
	
	public String getBody() throws URISyntaxException, IOException, InterruptedException {
		
		URI uri = new URI("https://imdb-api.com/en/API/Top250Movies/"+this.apiKey);
		
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(uri)
				.header("Content-Type", "application/json")
				.GET()
				.build();
		
		HttpClient cliente = HttpClient.newHttpClient();
		
		HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
		
		//pegando o corpo do json
		return response.body().substring(response.body().indexOf("[")+1, response.body().indexOf("]")+1);

	}


}
