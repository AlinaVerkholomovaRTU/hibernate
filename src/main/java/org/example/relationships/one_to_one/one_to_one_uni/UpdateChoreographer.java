package org.example.relationships.one_to_one.one_to_one_uni;

import org.example.relationships.one_to_one.entity.ChoreographerUni;
import org.example.relationships.one_to_one.entity.ChoreographerDetailsUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateChoreographer {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ChoreographerUni.class)
                .addAnnotatedClass(ChoreographerDetailsUni.class).
                buildSessionFactory();

        Session session = factory.openSession();
        try {

            session.beginTransaction();

            int theId = 1;
            ChoreographerUni tempChoreographer = session.get(ChoreographerUni.class, theId);
            ChoreographerDetailsUni tempDetails = session.get(ChoreographerDetailsUni.class, theId);

            //update the Choreographer object
            //This will also update details objects because of CascadeType=ALL
            if (tempChoreographer != null) {
                tempChoreographer.setLastName("White");
                tempDetails.setDanceType("hip-hop");
                session.persist(tempChoreographer);
            }
            else
                System.out.println("Choreographer not found");

            session.getTransaction().commit();


        } finally{
            session.close();

        }
        factory.close();

    }
}
