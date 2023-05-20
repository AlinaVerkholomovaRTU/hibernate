package org.example.performance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static java.lang.System.currentTimeMillis;

public class UpdatingRecords {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passport.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            int i = 1;
            long startTime = currentTimeMillis();

            while (i < 1001) {

                Passport passport = session.get(Passport.class, i);
                passport.setType("Emergency");
                session.beginTransaction();

                session.persist(passport);
                session.getTransaction().commit();

                i++;
            }
            long stopTime = currentTimeMillis();
            long time = stopTime - startTime;

            System.out.println("Required time for updating 1000 rows is: " + time);


        } finally {
            session.close();

        }
        factory.close();


    }
}
