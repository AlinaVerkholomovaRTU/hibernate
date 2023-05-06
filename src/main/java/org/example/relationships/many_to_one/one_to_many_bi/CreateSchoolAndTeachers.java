package org.example.relationships.many_to_one.one_to_many_bi;

import org.example.relationships.many_to_one.entity.SchoolBi;
import org.example.relationships.many_to_one.entity.TeacherBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class CreateSchoolAndTeachers {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SchoolBi.class)
                .addAnnotatedClass(TeacherBi.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            SchoolBi school = new SchoolBi("schoolBi", "Riga");
            TeacherBi teacher1 = new TeacherBi("Anna", "Smith");
            TeacherBi teacher2 = new TeacherBi("Marie", "Boyd");
            teacher1.setSchool(school);
            teacher2.setSchool(school);

            List<TeacherBi> teachers = new ArrayList<TeacherBi>();
            teachers.add(teacher1);
            teachers.add(teacher2);

            school.setTeachers(teachers);

            session.save(school);
            session.save(teacher1);
            session.save(teacher2);
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {

            session.close();

        }
        factory.close();

    }
}
