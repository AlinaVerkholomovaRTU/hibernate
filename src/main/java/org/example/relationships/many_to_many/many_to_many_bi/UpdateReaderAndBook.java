package main.java.org.example.relationships.many_to_many.many_to_many_bi;

import main.java.org.example.relationships.many_to_many.entity.BookBi;
import main.java.org.example.relationships.many_to_many.entity.ReaderBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateReaderAndBook {

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

            book.setAuthor("J. London");
            if (book.getReaders() != null) {
                for (ReaderBi reader : book.getReaders()) {
                    reader.setEmail("new@mail.com");
                    session.save(reader);
                }
            }
            else {
                System.out.println("Readers not found");
            }
            session.save(book);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

        }
        factory.close();
    }
}