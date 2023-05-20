package org.example.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CachingExample {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session1 = factory.openSession();

        Product product1 = session1.find(Product.class, 1);
        System.out.println(product1);

        session1.close();

        Session session2 = factory.openSession();

        Product product2 = session2.find(Product.class, 1);
        System.out.println(product2);


        session2.close();

    }
}