package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
         SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Students student1 = new Students();
        student1.setId(108);
        student1.setName("Ankit");
        student1.setCity("Haridwar");

        Certificate certificate=new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("2 months");
        student1.setCerti(certificate);
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
         s.save(student1);
        tx.commit();
        s.close();

         factory.close();
    }

}
