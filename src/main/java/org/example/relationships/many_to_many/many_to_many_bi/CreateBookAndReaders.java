package org.example.relationships.many_to_many.many_to_many_bi;

import org.example.relationships.many_to_many.entity.BookBi;
import org.example.relationships.many_to_many.entity.ReaderBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateBookAndReaders {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("src/hibernate.cfg.xml")
                .addAnnotatedClass(BookBi.class)
                .addAnnotatedClass(ReaderBi.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            BookBi book = new BookBi("Gone with the wind", "M. Mitchell");
            ReaderBi reader1 = new ReaderBi("Alex", "Thomas", "a.thomas@mail.com");
            ReaderBi reader2 = new ReaderBi("Meredith", "Johns", "m.johns@mail.com");

            List<ReaderBi> readers = new ArrayList<>();
            readers.add(reader1);
            readers.add(reader2);

            book.setReaders(readers);

            session.save(book);
            session.save(reader1);
            session.save(reader2);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

        }
        factory.close();

    }

}

