package example.hibernate.beans;

public class MovieTitleAndYear {
	private String title;
	private int year;
	
	public MovieTitleAndYear() {
		// TODO Auto-generated constructor stub
	}

	public MovieTitleAndYear(String title, int year) {
		super();
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "MovieTitleAndYear [title=" + title + ", year=" + year + "]";
	}

}
