package org.example.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "surname")
	private String surname;

	@Column(name = "name")
	private String name;

	@Column(name = "department")
	private String department;

	@Column(name = "salary")
	private int salary;

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
