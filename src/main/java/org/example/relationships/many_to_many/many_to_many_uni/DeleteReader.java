package org.example.relationships.many_to_many.many_to_many_uni;

import org.example.relationships.many_to_many.entity.BookUni;
import org.example.relationships.many_to_many.entity.ReaderUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteReader {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BookUni.class)
                .addAnnotatedClass(ReaderUni.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int theId = 2;

            ReaderUni reader = session.get(ReaderUni.class, theId);

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

