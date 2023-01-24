package Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        TestEmployee testEmployee = new TestEmployee();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TestEmployee.class)
                .buildSessionFactory();
        Session session = null;

        try {
            testEmployee.setName("fsdfsd");
            testEmployee.setLastName("greqasd");
            testEmployee.setSalary(23);

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(testEmployee);
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
