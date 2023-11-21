package one_to_many.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String departmentName;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="min_salary")
    private int minSalary;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH},
            mappedBy = "department")
    private List<Employee> employeeList = new ArrayList<>();

    public Department () {

    }

    public void addEmployeeList(List<Employee> employee) {
        if (this.employeeList == null) {
            this.employeeList = new ArrayList<>();
        }
        for(Employee empl : employee){
            this.employeeList.add(empl);
            empl.setDepartment(this);
        }
    }

    public Department(String departmentName, int maxSalary, int minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
