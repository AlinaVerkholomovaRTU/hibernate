package org.example.relationships.many_to_many.many_to_many_bi;

import org.example.relationships.many_to_many.entity.BookBi;
import org.example.relationships.many_to_many.entity.ReaderBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetReadersForBook {
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

            BookBi book = session.get(BookBi.class, theId);


            if (book != null) {

                for (ReaderBi reader : book.getReaders()) {
                    System.out.println(reader);
                }
            }
            else {
                System.out.println("Book not found");
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

        }
        factory.close();
    }
}

