package org.example.relationships.many_to_one.one_to_many_uni;

import org.example.relationships.many_to_one.entity.SchoolUni;
import org.example.relationships.many_to_one.entity.TeacherUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateSchoolAndTeachers {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SchoolUni.class)
                .addAnnotatedClass(TeacherUni.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            SchoolUni schoolUni = new SchoolUni("school1", "Riga");
            TeacherUni teacherUni1 = new TeacherUni("Anna", "Smith");
            TeacherUni teacherUni2 = new TeacherUni("Marie", "Boyd");

            teacherUni1.setSchool(schoolUni);
            teacherUni2.setSchool(schoolUni);

            session.persist(schoolUni);
            session.persist(teacherUni1);
            session.persist(teacherUni2);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();

        }
        factory.close();

    }
}
