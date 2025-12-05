package com.jspiders.project.bms;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo {
    static SessionFactory sessionFactory;

    static
    {
        //Step : Load Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.bms.cfg.xml");

        //Step : Build SessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void addAudiAndShows()
    {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        System.out.println("Creating Auditorium");
        Auditorium a1 = new Auditorium();
        a1 .setName("Audi-10");
        a1 .setSeatColumns(20);
        a1 .setSeatRows(50);

        System.out.println("Creating Show-1");
        Shows s1 = new Shows();
        s1.setEndTime(LocalDate.now());
        s1.setShowTime(LocalDate.now());
        s1.setStatus("AVAILABLE");

        System.out.println("Creating Show-2");
        Shows s2 = new Shows();
        s2.setEndTime(LocalDate.now());
        s2.setShowTime(LocalDate.now());
        s2.setStatus("AVAILABLE");

        System.out.println("Creating Show-3");
        Shows s3 = new Shows();
        s3.setEndTime(LocalDate.now());
        s3.setShowTime(LocalDate.now());
        s3.setStatus("AVAILABLE");

        //Linking Audi to Shows
        System.out.println("Linking Audi to Shows");
        a1.getShows().add(s1);
        a1.getShows().add(s2);
        a1.getShows().add(s3);

        System.out.println("Save Audi");
        session.persist(a1);

        transaction.commit();

        session.close();
    }

    public static void addShow(Long audiId)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Creating show");
        Shows s1 = new Shows();
        s1.setShowTime(LocalDate.now());
        s1.setEndTime(LocalDate.now());
        s1.setStatus("NEW-SHOW-S1");

        System.out.println("Finding Audi with id : "+audiId);
        Auditorium a1 = session.find(Auditorium.class,audiId);

        System.out.println("Linking show to audi");
        a1.getShows().add(s1);

        session.persist(a1);
        transaction.commit();
        System.out.println("Show added Successfully ======");

        session.close();
    }

    public static void getShowsByAudi(Long audiId)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Finding Audi with id : "+audiId);
        Auditorium auditorium = session.find(Auditorium.class,audiId);

        List<Shows> shows = auditorium.getShows();

        System.out.println("===============SHOW DETAILS=========");
        for (int i=0; i<=shows.size()-1; i++)
        {
            System.out.println();
            System.out.println(shows.get(i).getShowTime());
            System.out.println(shows.get(i).getEndTime());
            System.out.println(shows.get(i).getStatus());
            System.out.println();
        }
        System.out.println("===============SHOW DETAILS=========");
        transaction.commit();
        session.close();
    }

    public static void deleteAudi(Long audiId)
    {
        System.out.println("Delete auditorium by id : "+audiId);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Finding Audi with id : "+audiId);
        Auditorium auditorium = session.find(Auditorium.class,audiId);

        session.remove(auditorium);
        transaction.commit();

        System.out.println("Auditorium with given id deleted "+audiId);
        session.close();
    }

    public static void deleteShow(Long audiId,Long showId)
    {
        System.out.println("Delete auditorium by id : "+audiId);
        Session session = sessionFactory.openSession();

        System.out.println("Show with given id deleted "+audiId);
        session.close();
    }

    public static void main(String[] args) {

        System.out.println("Program starts...");

        addAudiAndShows();
        addShow(5l);

        //deleteAudi(5l);

        getShowsByAudi(5l);

        //Step : Close SessionFactory
        sessionFactory.close();

        System.out.println("Program ends...");

    }
}

