package example.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //This indicates that the Movie is not an ordinary class it is an entity.
@Table(name = "movie_master")
public class Movie {
	@Id // Applied at the field level of the movieId hence movieId is treated as the identity.
	
	@Column(name = "movie_Id", length = 4)
	private String movieId;
	
	@Column(name = "movie_title")
	private String title;
	
	@Column(name = "movie_genre")
	private String genre;
	
	@Column(name = "movie_year")
	private int year;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String movieId, String title, String genre, int year) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.year = year;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", year=" + year + "]";
	}

}
