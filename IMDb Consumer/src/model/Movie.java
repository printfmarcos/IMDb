package model;

public class Movie implements Content{
	
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


	@Override
	public String toString() {
		return "\nMovie \ntitle=" + this.title + ", \nurlImage=" + this.urlImage + ", \nrating=" + this.rating + ", \nyear=" + this.year + "\n";
	}

	@Override
	public String title() {
		return this.title;
	}

	@Override
	public String urlImage() {
		return this.urlImage;
	}

	@Override
	public String rating() {
		return this.rating.toString();
	}

	@Override
	public String year() {
		return this.year.toString();
	}


	@Override
	public int compareTo(Content c) {
		return this.rating().compareTo(c.rating());
	}
}
