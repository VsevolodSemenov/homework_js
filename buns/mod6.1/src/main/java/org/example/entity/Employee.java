package org.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private int id;

    private String name;

    private String surname;

    private int salary;

    private String department;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
