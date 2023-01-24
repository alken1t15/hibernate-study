package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {

//            session = factory.getCurrentSession();                       // Добавление сотрудников по bi
//            Department department = new Department("Sales",800,1500);
//            Employee emp1 = new Employee("Zaur","Tregulov",800);
//            Employee emp2 = new Employee("Elena","Smirnova",1500);
//            Employee emp3 = new Employee("Anton","Sidorov",1200);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(department);
//
//
//            session.getTransaction().commit();

            session = factory.getCurrentSession();                                    // Получение сотредников

            session.beginTransaction();
            Department department = session.get(Department.class,3);
            System.out.println(department);
            System.out.println(department.getEmps());
            session.getTransaction().commit();

//            session = factory.getCurrentSession();                                    // Получение сотредников
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class,1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();                                    // Получение сотредников
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class,1);
//
//            session.delete(employee);
//
//
//            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
