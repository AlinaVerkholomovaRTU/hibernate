package org.example.inheritance.table_per_subclass;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(LegalEntity.class)
                .addAnnotatedClass(Individual.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            Customer customer = new Customer();
            customer.setAmount(50);

            Individual tempIndividual = new Individual();
            tempIndividual.setName("Margaret");
            tempIndividual.setAmount(200);

            LegalEntity company = new LegalEntity();
            company.setRegisterNumber(1234566789);
            company.setAmount(500);

            session.save(customer);
            session.save(tempIndividual);
            session.save(company);

            session.getTransaction().commit();


        } finally{
            session.close();

        }
        factory.close();

        }
}
