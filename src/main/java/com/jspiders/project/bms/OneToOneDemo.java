package com.jspiders.project.bms;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
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

    public static void saveAudi()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Creating Audi data");
        Auditorium a1 = new Auditorium();
        a1.setName("AUDI-1");
        a1.setSeatRows(20);
        a1.setSeatColumns(30);

        System.out.println("Creating Address data");
        AudiAddress adr1 = new AudiAddress();
        adr1.setStreetName("Street-1");
        adr1.setArea("HBR");
        adr1.setCity("BLR");

        System.out.println("Linking Audi to Address ");
        a1.setAudiAddress(adr1);//link Audi to Address

        session.persist(a1);

        System.out.println("Audi and Address saved!!");

        transaction.commit();
        session.close();
        System.out.println("Session closed");
    }

    public static void deleteAudi(Long id)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Finding Audi data with id : "+id);
        Auditorium a1 = session.find(Auditorium.class,id);
        session.remove(a1);
        System.out.println("Audi and Address deleted!!");
        transaction.commit();
        session.close();
        System.out.println("Session closed");
    }

    public static void getAudiDetails(Long id)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Finding Audi data with id : "+id);
        Auditorium a1 = session.find(Auditorium.class,id);

        System.out.println(a1);

        transaction.commit();
        session.close();
        System.out.println("Session closed");
    }

    public static void main(String[] args) {

        System.out.println("Program starts...");

        //saveAudi();
        //  deleteAudi(1l);

        getAudiDetails(2L);

        System.out.println("4.Close Session Factory");
        sessionFactory.close();

        System.out.println("Program ends...");

    }
}

