package JsonParser;

import java.util.List;

import model.Content;

public interface JsonParser {
	
	 public List<? extends Content> parse();
}
