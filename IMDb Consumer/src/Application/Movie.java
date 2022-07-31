package Application;

public class Movie {
	
	private String title;
	private String urlImage;
	private Double rating;
	private Integer year;
	
	public Movie(String title, String urlImage, String year, String rating) {
		this.title = title;
		this.urlImage = urlImage;		
		this.year = Integer.parseInt(year);
		this.rating = Double.parseDouble(rating);
	}

	public String getTitle() {
		return title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public Double getRating() {
		return rating;
	}

	public Integer getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "\nMovie \ntitle=" + this.title + ", \nurlImage=" + this.urlImage + ", \nrating=" + this.rating + ", \nyear=" + this.year + "\n";
	}
}
