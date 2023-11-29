package java.com.example;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.com.example.validation.CheckEmail;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
public class Employee {

    @Size(min=2, message = "name must be 2 or more symbols long")
    private String name;

    @NotBlank
    private String surname;

    @Min(value=500)
    @Max(value=2000)
    private int salary;

    private String department;

    private List<String> departments;

    private String carBrand;

    private List<String> carBrands;

    private String[] languages;

    @CheckEmail
    private String email;

    @Pattern(regexp = "\\d{3} \\d{3}-\\d{2}-\\d{2}", message = "must match XXX XXX-XX-XX")
    private String phoneNumber;

    private List<String> langList;
    public Employee(){
        carBrands = new ArrayList<>();
        carBrands.add("BMW");
        carBrands.add("MB");
        carBrands.add("Audi");

        departments = new ArrayList<>();
        departments.add("HR");
        departments.add("Sales");
        departments.add("IT");

        langList = new ArrayList<>();
        langList.add("English");
        langList.add("French");
        langList.add("Chinese");
        langList.add("German");
    }
}
