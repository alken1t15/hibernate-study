package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> emps = session.createQuery("from Employee ").getResultList(); // Получение всех работников из таблицы
//            List<Employee> emps = session.createQuery("from Employee " + "where name = 'Василий'").getResultList(); // Получение всех работников из таблицы которых завот Василий name это поле из класса
            List<Employee> emps = session.createQuery("from Employee " + "where name = 'Василий' AND salary > 650").getResultList();

            for(Employee e: emps){
                System.out.println(e);
            }

            session.getTransaction().commit();


        }
        finally {
            sessionFactory.close();
        }
    }
}
