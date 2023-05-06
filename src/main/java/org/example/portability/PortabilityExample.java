package org.example.portability;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PortabilityExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passport.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            Passport passport = new Passport("AB-1111", "ordinary");

            session.save(passport);

            session.getTransaction().commit();

            System.out.println("done!");


        } finally {
            session.close();

        }
        factory.close();


}
}
