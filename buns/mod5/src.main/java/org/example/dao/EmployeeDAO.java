package java.org.example.dao;

import java.org.example.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
	List<Employee> getAll();

	void save(Employee employee);

	Employee getEmployee(int id);

	void delete(int id);
}
