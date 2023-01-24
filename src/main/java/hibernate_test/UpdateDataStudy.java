package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateDataStudy {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class,1); // 1 Способ обновления данных
//            employee.setSalary(455);
            session.createQuery("update Employee set salary = 2000" + " where name = 'Елена'").executeUpdate(); // 1 Способ обновления данных
//            for(Employee e: emps){
//                System.out.println(e);
//            }

            session.getTransaction().commit();


        }
        finally {
            sessionFactory.close();
        }
    }
}
