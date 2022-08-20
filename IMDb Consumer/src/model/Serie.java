package model;

public class Serie implements Content{
	
	private String title;
	private String urlImage;
	private String rating;
	private String  year;
	
	public Serie(String title, String urlImage, String rating, String year) {
		this.title = title;
		this.urlImage = urlImage;
		this.rating = rating;
		this.year = year;
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
		return this.rating;
	}
	@Override
	public String year() {
		return this.year;
	}
	@Override
	public int compareTo(Content c) {
		return this.rating().compareTo(c.rating());
	}
	
}
