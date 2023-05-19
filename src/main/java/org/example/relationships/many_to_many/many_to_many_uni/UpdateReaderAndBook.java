package org.example.relationships.many_to_many.many_to_many_uni;

import org.example.relationships.many_to_many.entity.BookUni;
import org.example.relationships.many_to_many.entity.ReaderUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateReaderAndBook {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BookUni.class)
                .addAnnotatedClass(ReaderUni.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int theId = 3;

            ReaderUni reader = session.get(ReaderUni.class, theId);
            reader.setLastName("Smith");

            if (reader.getBooks() != null) {

                for (BookUni book : reader.getBooks()) {
                    book.setTitle("The Hobbit");
                    session.save(book);
                }
            }
            else {
                System.out.println("Books not found");
            }
            session.save(reader);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

        }
        factory.close();
    }
}