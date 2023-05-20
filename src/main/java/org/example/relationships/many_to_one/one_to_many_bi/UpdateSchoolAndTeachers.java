package org.example.relationships.many_to_one.one_to_many_bi;


import org.example.relationships.many_to_one.entity.SchoolBi;
import org.example.relationships.many_to_one.entity.TeacherBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateSchoolAndTeachers {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SchoolBi.class)
                .addAnnotatedClass(TeacherBi.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int theId = 11;

            TeacherBi teacher = session.get(TeacherBi.class, theId);
            SchoolBi school = teacher.getSchool();

            if (school != null) {
                school.setName("Lyceum");
                school.setTeachers(null);
                session.persist(school);

                if (school.getTeachers() != null) {
                    for (TeacherBi teacherTemp : school.getTeachers()) {
                        teacherTemp.setFirstName("Adam");
                        session.persist(teacherTemp);
                    }
                }
                else{
                    System.out.println("Teachers not found");
                }
            }
            else
                System.out.println("School not found");

            session.getTransaction().commit();


        } finally{

            session.close();

        }
        factory.close();
    }
}
