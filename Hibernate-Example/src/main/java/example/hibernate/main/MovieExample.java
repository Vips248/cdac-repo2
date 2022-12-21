package example.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import example.hibernate.beans.MovieTitleAndYear;
import example.hibernate.entities.Movie;
import example.hibernate.utilities.HibernateUtils;

public class MovieExample {
	private static void create() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		Movie currentMovie = new Movie("M5","Teesri Aankh","Suspense",1988);
		Transaction tx = session.beginTransaction();
		session.save(currentMovie);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Movie record added");
	}
	private static void hqlUsingSelectClause() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		
		//Building a query string
		String hqlQuery = "select m.title,m.year from Movie m";
		//Obtain the reference of type Query
		Query<Object[]> qrMovie = session.createQuery(hqlQuery);
		List<Object[]> movieList = qrMovie.list();
		System.out.println("Printing the title and year of all the Movies");
		for(Object[] movieData : movieList) {
			System.out.println("Title = " + movieData[0] + ", Year = " + movieData[1]);
		}
		
	}
	private static void hqlUsingFromClause() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		
		//Building a query string
		String hqlQuery = "from Movie m";
		//Obtain the reference of type Query
		Query<Movie> qrMovie = session.createQuery(hqlQuery);
		
		//Obtain the list of Movie objects from this query reference
		List<Movie> allMovies = qrMovie.list();
		System.out.println("Printing all the Movies :");
		for(Movie currentMovie : allMovies) {
			System.out.println(currentMovie);
		}
	}
	private static void hqlUsingConstructorExpression() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		
		//Building a query string
		String hqlQuery = "select new example.hibernate.beans.MovieTitleAndYear(m.title,m.year)from Movie m";
		Query<MovieTitleAndYear> qr = session.createQuery(hqlQuery);
		List<MovieTitleAndYear> movieData = qr.list();
		for(MovieTitleAndYear movie : movieData) {
			System.out.println(movie.getTitle() + " - " + movie.getYear());
		}
		session.close();
		factory.close();
	}
	
	private static void hqlUsingCriteria () {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		//Obtaining a reference of type Criteria
		Criteria cr = session.createCriteria(Movie.class);
		List<Movie> allMovies = cr.list();
		for(Movie mv : allMovies) {
			System.out.println(mv);
		}
		session.close();
		factory.close();	
	}
	
	private static void hqlUsingCriteriaWithRestriction() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		//Obtaining a reference of type Criteria
		Criteria cr = session.createCriteria(Movie.class);
		//Adding some restrictions to fetch those movies released between 1975 and 1990
		cr.add(Restrictions.between("year", 1975, 1990));
		List<Movie> allMovies = cr.list();
		for(Movie mv : allMovies) {
			System.out.println(mv);
		}
		session.close();
		factory.close();	
	}
	public static void main(String[] args) {
		//hqlUsingFromClause();
		//hqlUsingSelectClause();
		//hqlUsingConstructorExpression();
		//hqlUsingCriteria();
		hqlUsingCriteriaWithRestriction();                         
	}

}
