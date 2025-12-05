package com.jspiders.project.bms;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
public class Mainclass {
    private static SessionFactory sessionFactory = null;

    static
    {
        //load configuration
        System.out.println("1.Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //create sessionfactory
        System.out.println("2.Create SessionFactory");
        sessionFactory = config.buildSessionFactory();
    }


    public static void addMovie()
    { //create session
        System.out.println("3.Create Session");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //logics
        Movie movie1 = new Movie();
        movie1.setTitle("K.G.F");
        movie1.setLanguage("KAN");
        movie1.setCertification("U/A");
        movie1.setDuration(120);
        movie1.setStatus(MovieStatus.AVAILABLE);
        movie1.setCreatedAt(LocalDate.now());
        movie1.setCreatedBy(123l);

        try {
            System.out.println("4.Save Entity to DB");
            session.persist(movie1);//persist-->save
            transaction.commit();
            System.out.println("Save Entity to DB SUCCESS");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        System.out.println("5.Close Session");
        session.close();
    }

    public static void updateMovie()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("4.Find the movie by ID");
        Movie movie = session.find(Movie.class,1);//select * from movie where id = 1

        System.out.println("5.Update the movie data");

        movie.setDuration(150);
        movie.setStatus(MovieStatus.AVAILABLE);
        movie.setUpdatedAt(LocalDate.now());
        movie.setUpdatedBy(218l);

        session.merge(movie);//update db
        transaction.commit();

        System.out.println("Update Success");

        System.out.println("6.Close Session");
        session.close();
    }

    public static void getMovie(Long id)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Movie movie = session.find(Movie.class,id);
        transaction.commit();

        System.out.println("Movie Found");
        System.out.println(movie);
    }

    public static void deleteMovie(Long id)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Movie movie = session.find(Movie.class,id);
        session.remove(movie);//delete
        transaction.commit();
        System.out.println("Movie Deleted");
    }

    public static void main(String[] args) {
        System.out.println("Program starts...");

        addMovie();
//        updateMovie();
//        getMovie(1l);
//        deleteMovie(1l);

        System.out.println("6.Close Session Factory");
        sessionFactory.close();

        System.out.println("Program ends...");
    }
}

