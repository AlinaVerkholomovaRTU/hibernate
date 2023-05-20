package org.example.relationships.one_to_one.one_to_one_bi;

import org.example.relationships.one_to_one.entity.ChoreographerBi;
import org.example.relationships.one_to_one.entity.ChoreographerDetailsBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetChoreographer {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ChoreographerBi.class)
                .addAnnotatedClass(ChoreographerDetailsBi.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        try {

            session.beginTransaction();

            int theId = 2;

            ChoreographerDetailsBi tempDetail = session.get(ChoreographerDetailsBi.class, theId);

            System.out.println(tempDetail);

            System.out.println(tempDetail.getChoreographerBi());

            session.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        factory.close();

    }
}
