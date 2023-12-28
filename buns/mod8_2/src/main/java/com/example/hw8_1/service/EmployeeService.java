package com.example.hw8_1.service;

import com.example.hw8_1.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee);

    public void delete(int id);

    public List<Employee> getAll();

    public Employee getEmployee(int id);

    public List<Employee> findAllByName(String name);
}
