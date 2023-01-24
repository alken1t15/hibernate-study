package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDataStudy {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class,1); //1 способ удаления
//            session.delete(employee);// удаление из бд
            session.createQuery("delete Employee " + "where salary = 2000").executeUpdate();


            session.getTransaction().commit();


        }
        finally {
            sessionFactory.close();
        }
    }
}
