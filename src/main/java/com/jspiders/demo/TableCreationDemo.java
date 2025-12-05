package com.jspiders.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TableCreationDemo {
    public static void main(String[] args)
    {
        System.out.println("Program starts..");

        System.out.println("Loading configuration..");
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        System.out.println("Build SessionFactory..");
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("Open Session..");
        Session session = sessionFactory.openSession();

        //logics
        System.out.println("Execute logics");


        session.close();
        System.out.println("Closed Session");
        sessionFactory.close();
        System.out.println("Closed SessionFactory");

        System.out.println("Program ends..");
    }
}

