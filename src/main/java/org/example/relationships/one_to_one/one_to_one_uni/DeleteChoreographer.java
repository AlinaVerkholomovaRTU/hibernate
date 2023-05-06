package org.example.relationships.one_to_one.one_to_one_uni;

import org.example.relationships.one_to_one.entity.ChoreographerUni;
import org.example.relationships.one_to_one.entity.ChoreographerDetailsUni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteChoreographer {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ChoreographerUni.class)
                .addAnnotatedClass(ChoreographerDetailsUni.class).
                buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

    try {
          //start a transaction
        session.beginTransaction();

        //get Choreographer by primary key / id
        int theId = 1;
        ChoreographerUni tempChoreographer = session.get(ChoreographerUni.class, theId);

        //delete the Choreographer object
        //This will also delete details objects because of CascadeType=ALL
        if (tempChoreographer != null)
            session.delete(tempChoreographer);
        else
            System.out.println("Choreographer not found");

        //commit transaction
        session.getTransaction().commit();

        System.out.println("done!");

    } finally{
        session.close();

    }
        factory.close();

    }
}
