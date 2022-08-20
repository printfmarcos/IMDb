package Utils;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import model.Content;

public class HTMLGenerator {
	
	private Writer writer;

	public HTMLGenerator(PrintWriter writer) {
		this.writer = writer;
	}
	
	public void generate(List<? extends Content> contentList) {
		
		String html = """
				<!DOCTYPE html>
				<html lang="pt-br">
				  %s
				""";
		
		String head =
				"""
				<head>
					<meta charset=\"utf-8\">
					<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
					<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
				</head>
				<body>
				""";
		
		((PrintWriter) writer).println(String.format(html, head));
		
		String divTemplate =
				"""
				<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
					<h4 class=\"card-header\">%s</h4>
					<div class=\"card-body\">
						<img class=\"card-img\" src=\"%s\" alt=\"%s\">
						<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
					</div>
				</div>
				""";
		
		//usando o template com os dados do filme			
		for (Content content : contentList) {
			((PrintWriter) writer).print(String.format(divTemplate, content.title(), content.urlImage(), content.title(), content.rating(), content.year()));
		}
		
		String endHtml = """
				  </body>
				</html>
				""";
		((PrintWriter) writer).println(endHtml);
	
	}

}
