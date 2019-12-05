package com.duannd.java9.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHelper {

    private EmployeeHelper() {

    }

    public static List<Employee> getEmployees() {
        Employee e1 = new Employee(1, "Pankaj");
        Employee e2 = new Employee(2, "David");
        Employee e3 = new Employee(3, "Lisa");
        Employee e4 = new Employee(4, "Ram");
        Employee e5 = new Employee(5, "Anupam");

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        return employees;
    }

}
