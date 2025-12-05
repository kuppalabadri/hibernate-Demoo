package com.jspiders.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserHQLdemo {
    public static void main(String[] args) {


        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        //get session from session factory
        Session session = sessionFactory.openSession();//connect to db
        System.out.println("session created..");

        //logics
   String selectUsersByName_HQL="FROM Users usr WHERE usr.name='user1'";
  Query<Users>query= session.createQuery(selectUsersByName_HQL,Users.class);
  Users users=query.uniqueResult();
        System.out.println(users);

        //close session
        session.close();
        System.out.println("session closed..");
        //close session factory
        sessionFactory.close();
        System.out.println("sessionFactory closed..");

        System.out.println("Program ends...");

    }
    }

