package main.java.org.example.performance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static java.lang.System.currentTimeMillis;

public class CreatingRecords {
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

                Passport passport = new Passport("AB-1111", "ordinary");
                session.beginTransaction();

                session.save(passport);
                session.getTransaction().commit();

                i++;
            }
            long stopTime = currentTimeMillis();
            long time = stopTime - startTime;

            System.out.println("Required time for creating 1000 rows is: " + time);


        } finally {
            session.close();

        }
        factory.close();


    }
}
