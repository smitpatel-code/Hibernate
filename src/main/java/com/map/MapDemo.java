package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
public static void main(String[] args) {
    SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Question q1=new Question();
    q1.setQuestionId(1212);
    q1.setQuestion("What is Java");

    Answer answer=new Answer();
    answer.setAnswerId(343);
    answer.setAnswer("Java is programming language");
    answer.setQuestion(q1);

    q1.setAnswer(answer);    

    Session s=factory.openSession();

Transaction tx=s.beginTransaction();

    s.save(q1);
    s.save(answer);
    tx.commit();
    Question newQ=(Question)s.get(Question.class, 1212);
    System.out.println(newQ.getQuestion());
    System.out.println(newQ.getAnswer().getAnswer());
    
    s.close();


    factory.close();
}
}
