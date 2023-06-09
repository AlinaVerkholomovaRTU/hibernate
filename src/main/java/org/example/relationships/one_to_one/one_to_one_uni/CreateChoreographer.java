package org.example.relationships.one_to_one.one_to_one_uni;

import org.example.relationships.one_to_one.entity.ChoreographerUni;
import org.example.relationships.one_to_one.entity.ChoreographerDetailsUni;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;


public class CreateChoreographer {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ChoreographerUni.class)
                .addAnnotatedClass(ChoreographerDetailsUni.class).
                buildSessionFactory();

        Session session = factory.openSession();

        try {

            ChoreographerDetailsUni tempDetails = new ChoreographerDetailsUni(12,
                    "tango");
            ChoreographerUni tempChoreographer = new ChoreographerUni("Paul", "Wall",
                    tempDetails);

            session.beginTransaction();

            session.persist(tempDetails);

            session.persist(tempChoreographer);

            session.getTransaction().commit();


        } finally{
            session.close();

        }
        factory.close();

    }
}
