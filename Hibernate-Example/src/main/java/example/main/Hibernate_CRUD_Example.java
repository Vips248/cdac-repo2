package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.entity.Course;

public class Hibernate_CRUD_Example {
	
	private static void create() {
		Configuration conf = new Configuration().configure();
		
		//Building SessionFactory
		SessionFactory factory = conf.buildSessionFactory();
		
		//Building a Session
		Session session = factory.openSession();
		
		//Building a Transaction
		Transaction tx = session.beginTransaction();//Here Transaction Starts
		
		Course crs = new Course("C++","C plus plus",8,7000);
		Course crs1 = new Course("SQL","Structured Querry Language",15,6000);
		
		session.save(crs);//This results into DML INSERT
		session.save(crs1);
		
		tx.commit();//Committing the Transaction
		
		session.close();
		
		factory.close();
		
		System.out.println("Course Created Successfully");
	}
	
	public static void main(String[] args) {
		create();
	}
} 