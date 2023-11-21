package one_to_one;

import one_to_many.entity.Department;
import one_to_one.entity.Detail;
import one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneToOne {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = getSessionFactory(); Session session = sessionFactory.getCurrentSession()) {
            Employee employee = getEmployeeFromStdin();
            Detail detail = getDetailFromStdin();

            employee.setDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();
            session.save(employee);

            int id = employee.getId();
            Employee employeeSaved = session.get(Employee.class, id);

            session.getTransaction().commit();
            System.out.println("The employee was saved: " + employeeSaved);
        }
    }

    private static Employee getEmployeeFromStdin() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Employee name: ");
            String name = reader.readLine();
            System.out.print("Employee surname: ");
            String surname = reader.readLine();
            System.out.print("Employee department: ");
            String department = reader.readLine();
            System.out.print("Employee salary: ");
            int salary = Integer.parseInt(reader.readLine());
            return new Employee(name, surname, department, salary);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Detail getDetailFromStdin() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Employee city: ");
            String city = reader.readLine();
            System.out.print("Employee phone number: ");
            String phoneNumber = reader.readLine();
            System.out.print("Employee mail: ");
            String mail = reader.readLine();
            return new Detail(city, phoneNumber, mail);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
    }
}
