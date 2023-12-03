package java.org.example.service;

import java.org.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> getAll();

	void save(Employee employee);

	Employee getEmployee(int id);

	void delete(int id);
}
