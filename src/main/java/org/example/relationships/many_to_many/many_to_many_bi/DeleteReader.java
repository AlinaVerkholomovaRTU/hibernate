package org.example.relationships.many_to_many.many_to_many_bi;

import org.example.relationships.many_to_many.entity.BookBi;
import org.example.relationships.many_to_many.entity.ReaderBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteReader {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BookBi.class)
                .addAnnotatedClass(ReaderBi.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;

            ReaderBi reader = session.get(ReaderBi.class, theId);

            if (reader != null) {

                session.delete(reader);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

        }
        factory.close();
    }
}

