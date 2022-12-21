package example.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.entities.Movie;

public class HibernateUtils {
	
	public static SessionFactory buildSessionFactory() {
		Configuration conf = new Configuration().configure();
		//Registering Movie entity with configuration.
		Class<Movie>movieType = Movie.class;
		conf.addAnnotatedClass(movieType);
		SessionFactory sf = conf.buildSessionFactory();
		return sf;
	}
	
}
