package org.example.relationships.one_to_one.one_to_one_bi;

import org.example.relationships.one_to_one.entity.ChoreographerDetailsBi;
import org.example.relationships.one_to_one.entity.ChoreographerBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateChoreographer {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ChoreographerBi.class)
                .addAnnotatedClass(ChoreographerDetailsBi.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            ChoreographerBi tempChoreographer = new ChoreographerBi("David", "Walles");

            ChoreographerDetailsBi tempDetail = new ChoreographerDetailsBi( 12, "salsa");

            tempChoreographer.setChoreographerDetailsBi(tempDetail);

            session.beginTransaction();

            session.persist(tempChoreographer);

            session.getTransaction().commit();


        } finally{
            session.close();

        }
        factory.close();

    }
}
