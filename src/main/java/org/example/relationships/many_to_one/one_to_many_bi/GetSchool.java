package org.example.relationships.many_to_one.one_to_many_bi;

import org.example.relationships.many_to_one.entity.SchoolBi;
import org.example.relationships.many_to_one.entity.TeacherBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSchool {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SchoolBi.class)
                .addAnnotatedClass(TeacherBi.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int teacherId = 10;

            TeacherBi teacher = session.get(TeacherBi.class, teacherId);

            if (teacher != null) {

                SchoolBi school = teacher.getSchool();

                System.out.println(school);
            }
            else {
                System.out.println("Teacher not found");
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
