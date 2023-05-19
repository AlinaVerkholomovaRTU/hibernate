package org.example.relationships.one_to_one.one_to_one_bi;


import org.example.relationships.one_to_one.entity.ChoreographerBi;
import org.example.relationships.one_to_one.entity.ChoreographerDetailsBi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteChoreographer {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ChoreographerBi.class)
                .addAnnotatedClass(ChoreographerDetailsBi.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

    try {
        session.beginTransaction();

        int theId = 2;
        ChoreographerBi tempChoreographer = session.get(ChoreographerBi.class, theId);

        if (tempChoreographer != null)
            session.delete(tempChoreographer);
        else
            System.out.println("Choreographer not found");

        session.getTransaction().commit();

    } finally{
        session.close();

    }
        factory.close();

    }
}
