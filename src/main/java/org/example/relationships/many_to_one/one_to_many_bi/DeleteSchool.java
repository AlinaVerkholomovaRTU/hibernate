package org.example.relationships.many_to_one.one_to_many_bi;

import org.example.relationships.many_to_one.entity.SchoolBi;
import org.example.relationships.many_to_one.entity.TeacherBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteSchool {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SchoolBi.class)
                .addAnnotatedClass(TeacherBi.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int schoolId = 2;

            SchoolBi school = session.get(SchoolBi.class, schoolId);


            if (school != null) {

                for (TeacherBi teacher : school.getTeachers()){
                    teacher.setSchool(null);
                }

                session.delete(school);

            }

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {

            session.close();

        }
        factory.close();

    }
}
