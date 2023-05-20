package org.example.relationships.many_to_many.many_to_many_uni;

import org.example.relationships.many_to_many.entity.BookUni;
import org.example.relationships.many_to_many.entity.ReaderUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateBookAndReaders {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BookUni.class)
                .addAnnotatedClass(ReaderUni.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            BookUni book1 = new BookUni("Gone with the wind", "M. Mitchell");
            BookUni book2 = new BookUni("Lord of the Rings", "J. R. R. Tolkien");

            ReaderUni reader = new ReaderUni("Alex", "Thomas", "a.thomas@mail.com");

            List<BookUni> books = new ArrayList<>();
            books.add(book1);
            books.add(book2);

            reader.setBooks(books);

            session.persist(book1);
            session.persist(book2);
            session.persist(reader);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

        }
        factory.close();

    }

}

