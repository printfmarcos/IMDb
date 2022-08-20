package Client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbApiClient implements APIClient{
	
	private String apiKey;

	public ImdbApiClient(String apiKey) {
		this.apiKey = apiKey;
	}	
	
	public String getBody(){
		try {
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
