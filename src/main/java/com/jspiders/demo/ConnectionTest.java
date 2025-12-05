package com.jspiders.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionTest {
    public static void main(String[] args) {
        System.out.println("Program starts..... ");

        System.out.println("Step 1 : Load the config");
        //Step 1 : Load the config
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        System.out.println("Step 2 : Build Session Factory");
        //Step 2 : Build Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        System.out.println("Step 3 : Create/Open Session");
        //Step 3 : Create/Open Session
        Session session = sessionFactory.openSession();

        //Step 4 : logics
        System.out.println("Step 4 : Execute Logics");

        //Step 5 : close session
        System.out.println("Step 5 : close session");
        session.close();

        System.out.println("Step 6 : close session factory");
        //Step 6 : close session factory
        sessionFactory.close();
    }
}

