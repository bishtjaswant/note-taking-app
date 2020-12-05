package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    private static SessionFactory sessionFactory= null;



    public static SessionFactory getSessionFactory(){

        if (sessionFactory==null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory(){
        if (sessionFactory.isOpen()){
            sessionFactory.close();
        }
    }
}
