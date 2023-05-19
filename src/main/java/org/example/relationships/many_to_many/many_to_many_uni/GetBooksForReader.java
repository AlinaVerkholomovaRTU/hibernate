package main.java.org.example.relationships.many_to_many.many_to_many_uni;

import main.java.org.example.relationships.many_to_many.entity.BookUni;
import main.java.org.example.relationships.many_to_many.entity.ReaderUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetBooksForReader {
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

            if (reader != null) {

                for (BookUni book : reader.getBooks()) {
                    System.out.println(book);
                }
            }
            else {
                System.out.println("Reader not found");
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

        }
        factory.close();
    }
}

