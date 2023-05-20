package org.example.constraints;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

public class ConstraintsExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(School.class)
                .addAnnotatedClass(Teacher.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            School school = new School();
            session.persist(school);

            Teacher teacher1 = new Teacher();
            teacher1.setSchool(school);
            session.persist(teacher1);

            Teacher teacher2 = new Teacher();
            teacher2.setSchool(school);
            session.persist(teacher2);

            session.getTransaction().commit();

        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        factory.close();
    }
}
