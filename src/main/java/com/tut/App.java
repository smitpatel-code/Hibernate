package com.tut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started" );
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
       Students st=new Students();
       st.setId(103);
       st.setName("Smit");
       st.setCity("Ahmedabad");
       System.out.println(st);
       
       //creating address
       Address ad=new Address();
       ad.setStreet("street1");
       ad.setCity("Ahmedabad");
       ad.setOpen(true);
       ad.setAddedDate(new Date());
       ad.setX(202.202);
       FileInputStream fis=new FileInputStream("src/main/java/download.jpeg");
       byte[] data=new byte[fis.available()];
       fis.read(data);
       ad.setImage(data);
       
       
       
       Session session=factory.getCurrentSession();
       
       session.beginTransaction();
       session.save(st);
       session.save(ad);
       session.getTransaction().commit();
       
       session.close();
       System.out.println("Done");

    }
}
