package java.org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@Size(min = 2, message = "name must be 2 or more symbols long")
	private String name;

	@Column(name = "surname")
	@NotBlank
	private String surname;

	@Column(name = "department")
	private String department;

	@Min(200)
	@Max(2000)
	@Column(name = "salary")
	private int salary;

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + "'" +
				", surname='" + surname + "'" +
				", department='" + department + "'" +
				", salary=" + salary +
				'}';
	}
}
