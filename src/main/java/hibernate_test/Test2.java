package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

//            Employee employee = new Employee("Елена", "Петрова", "Sales", 800);
//
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();

            int myid = 3;
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class,myid); // получение данных из таблицы по id
            session.getTransaction().commit();
            System.out.println(employee1);
            System.out.println("ГЕЙ");

        }
        finally {
            sessionFactory.close();
        }
    }
}
