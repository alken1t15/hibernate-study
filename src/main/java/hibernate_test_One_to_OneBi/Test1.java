package hibernate_test_One_to_OneBi;


import hibernate_test_One_to_OneBi.entity.Detail;
import hibernate_test_One_to_OneBi.entity.Employee;
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
//             session = factory.getCurrentSession();
//            Employee emp = new Employee("Максим", "Черт", "It", 500);
//            Detail detail = new Detail("Baku","123456789","zaurtregulov@gmail.com");
//            emp.setEmpDetail(detail);
//            detail.setEmployee(emp);
//            session.beginTransaction();
//            session.save(detail);
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail = session.get(Detail.class,3);
            detail.getEmployee().setEmpDetail(null); // Для разрушение связи между таблицами
            session.delete(detail);
            session.getTransaction().commit();
            System.out.println(detail.getEmployee());

        } finally {
            session.close();
            factory.close();
        }
    }
}
