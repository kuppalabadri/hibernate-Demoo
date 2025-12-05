package com.jspiders.project.bms;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;

public class CriteriaQuerydemo {
    public static void main(String[] args) {


    Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

    //build session factory
    SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

    //get session from session factory
    Session session = sessionFactory.openSession();//connect to db
        System.out.println("session created..");

    //logics

        //step-1:get criteriaBuilder
        CriteriaBuilder cb=session.getCriteriaBuilder();


      //step-2:create criteria query using criteria builder with enity class
        CriteriaQuery<Movie> query = cb.createQuery(Movie.class);

   //step-3: define the table name
        Root<Movie> table = query.from(Movie.class);

        //step-4:define the conditions/criteria/predicates
        Predicate condition1 = cb.equal(table.get("status"), MovieStatus.AVAILABLE);
        Predicate condition2 = cb.equal(table.get("title"), "K.G.F");

        //step-5:build the query using table and conditions
        query.select(table).where(condition1,condition2);


        Query<Movie> query1 = session.createQuery(query);
//        Movie movie = query1.uniqueResult();
//        System.out.println(movie);

        List<Movie> resultlist=query1.getResultList();
        for (Movie movi :resultlist) {
            System.out.println(movi);

        }
//        Query<Movie> query2 = session.createQuery(query);
//        List<Movie> resultlist2=query2.getResultList();
//        for(Movie mov:resultlist2){
//            System.out.println(mov);
//        }



        //close session
        session.close();
        System.out.println("session closed..");
    //close session factory
        sessionFactory.close();
        System.out.println("sessionFactory closed..");

        System.out.println("Program ends...");

}
}
