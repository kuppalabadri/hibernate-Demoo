package com.jspiders.demo;

import com.jspiders.project.bms.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class hqldemologin {
    static SessionFactory sessionFactory;



public static void login(){
    //load configuration
    Configuration config = new Configuration();
    config.configure("hibernate.cfg.xml");

    //build session factory
    sessionFactory = config.buildSessionFactory();
    System.out.println("sessionFactory created..");

    //get session from session factory
//    Session session = sessionFactory.openSession();//connect to db
//    System.out.println("session created..");

    //logics
    Scanner s1=new Scanner(System.in);
    System.out.println("enter the mob");
    String mob=s1.next();

    System.out.println("enter the password");
    String password=s1.next();

    String selectUsersByName_HQL="FROM Users u  WHERE u.password= :password AND u.mobile=:mob";

    Session session=sessionFactory.openSession() ;
    Query<Users> query= session.createQuery(selectUsersByName_HQL, Users.class);

    query.setParameter("password", password);
    query.setParameter("mob", mob);

    Users user=query.uniqueResult();
    if(user !=null) {
        System.out.println("login successfully");
    }
        else {
        System.out.println("failed");
    }
    //close session
    session.close();
    System.out.println("session closed..");
    //close session factory


}

    public static void main(String[] args) {
    login();
        sessionFactory.close();

    }


}


