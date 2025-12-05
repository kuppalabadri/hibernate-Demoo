package com.jspiders.demo;


import jakarta.persistence.*;


//EntityClass
    @Entity
    @Table(name = "emp")
    public class Employee {

        @Id//Primary Key
        @GeneratedValue(strategy = GenerationType.IDENTITY )//AI
        @Column(name = "empno")
        private Long empNo;

        @Column(name = "ename",nullable = false)
        private String empName;

        @Column(name = "email",nullable = false,unique = true)
        private String empEmail;

        @Transient
        private static final String companyName = "jsp";
    }

