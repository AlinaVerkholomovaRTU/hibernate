package org.example.relationships.many_to_one.one_to_many_uni;

import org.example.relationships.many_to_one.entity.SchoolUni;
import org.example.relationships.many_to_one.entity.TeacherUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSchool {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SchoolUni.class)
                .addAnnotatedClass(TeacherUni.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int schoolId = 2;

            SchoolUni schoolUni = session.get(SchoolUni.class, schoolId);

            if (schoolUni != null) {

                System.out.println(schoolUni);

            }
            else {
                System.out.println("School not found");
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
