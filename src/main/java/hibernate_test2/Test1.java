package hibernate_test2;


import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
//            Session session = factory.getCurrentSession();
//            Employee emp = new Employee("Zaur", "Tregulov", "It", 500);
//            Detail detail = new Detail("Baku","123456789","zaurtregulov@gmail.com");
//            emp.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(emp);
//            session.getTransaction().commit();


//            Session session = factory.getCurrentSession();
//            Employee emp = new Employee("Oleg", "Smirnov", "Sales", 700);
//            Detail detail = new Detail("Moscow","987654321","olejka@gmail.com");
//            emp.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(emp);
//            session.getTransaction().commit();


//             session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee.getEmpDetail());
//            session.getTransaction().commit();

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
