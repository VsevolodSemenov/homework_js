package one_to_many;

import one_to_many.entity.Department;
import one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = getSessionFactory(); Session session = sessionFactory.getCurrentSession()) {
            Employee employee = new Employee("1", "1", 100);
            Employee employee1 = new Employee("2", "2", 200);
            Employee employee2 = new Employee("3", "3", 300);
            Department department = new Department("dep", 2300, 100);
            department.addEmployeeList(List.of(employee, employee2, employee1));
            session.beginTransaction();
            List<Department> list = session.createQuery("from Department").getResultList();
            list.forEach(e -> System.out.println(e.getEmployeeList()));
            session.getTransaction().commit();
        }
    }
    private static SessionFactory getSessionFactory(){
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
    }
}
