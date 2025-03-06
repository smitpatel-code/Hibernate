package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session=factory.openSession();
	    Students student=(Students)session.load(Students.class, 101);
	    System.out.println(student);
	    
	    factory.close();

	}

}
