package main.java.org.example.lazy_loading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class LazyLoadingExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(School.class)
                .addAnnotatedClass(Teacher.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            int id = 1;
            School school = session.get(School.class, id);

            System.out.println("School: " + school);

            System.out.println("Teachers: " + school.getTeachers());


        } finally {
            session.close();

        }
        factory.close();


    }
}
