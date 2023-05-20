package org.example.transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TransactionExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BankAccount.class).
                buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        try {
            int amount = 100;
            BankAccount bankAccount1 = session.get(BankAccount.class, 1);
            BankAccount bankAccount2 = session.get(BankAccount.class, 2);

            if (bankAccount1 != null) {
                bankAccount1.setBalance(bankAccount1.getBalance() - amount);
                bankAccount2.setBalance(bankAccount2.getBalance() + amount);
                session.persist(bankAccount1);
                session.persist(bankAccount2);
            }
            else
                System.out.println("Bank account not found");

            transaction.commit();
            System.out.println("Committed!");

        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Rollback!");
            e.printStackTrace();

        } finally {
            session.close();
        }

        factory.close();
    }

}
