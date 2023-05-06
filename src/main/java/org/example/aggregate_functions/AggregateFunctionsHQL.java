package org.example.aggregate_functions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Random;

import static java.lang.System.currentTimeMillis;

public class AggregateFunctionsHQL {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try{

            Random rand = new Random();
            int i = 1;
            while (i < 1001) {
                int salaryRand = rand.nextInt(5001);
                session.save(new Employee("Andrew", salaryRand));
                i++;
            }
            long startTime1 = currentTimeMillis();

            Double averageSalary = (Double)session.createQuery("SELECT avg(salary) from Employee")
                                                    .getSingleResult();

            System.out.println("Average salary: " + averageSalary);

            long stopTime1 = currentTimeMillis();
            long time1 = stopTime1 - startTime1;
            System.out.println("Time to get average salary is: " + time1);

            long startTime2 = currentTimeMillis();

            Double maxSalary = (Double)session.createQuery("SELECT max(salary) from Employee")
                    .getSingleResult();

            System.out.println("\nMaximum salary: " + maxSalary);
            long stopTime2 = currentTimeMillis();
            long time2 = stopTime2 - startTime2;

            System.out.println("Time to get max salary is: " + time2);

            long startTime3 = currentTimeMillis();

            Double minSalary = (Double)session.createQuery("SELECT min(salary) from Employee")
                    .getSingleResult();

            System.out.println("\nMinimum salary: " + minSalary);

            long stopTime3 = currentTimeMillis();
            long time3 = stopTime3 - startTime3;
            System.out.println("Time to get min salary is: " + time3);

            long startTime4 = currentTimeMillis();

            Double sumSalary = (Double)session.createQuery("SELECT sum(salary) from Employee")
                    .getSingleResult();

            System.out.println("\nSummary salary: " + sumSalary);

            long stopTime4 = currentTimeMillis();
            long time4 = stopTime4 - startTime4;
            System.out.println("Time to get sum of salaries is: " + time4);

            long startTime5 = currentTimeMillis();

            Long countEmployee = (Long) session.createQuery("SELECT count(*) from Employee")
                    .getSingleResult();

            System.out.println("\nAmount of employees: " + countEmployee);

            long stopTime5 = currentTimeMillis();
            long time5 = stopTime5 - startTime5;
            System.out.println("Time to get min salary is: " + time3);

        } finally {

         session.close();

    }
        factory.close();

    }
}
