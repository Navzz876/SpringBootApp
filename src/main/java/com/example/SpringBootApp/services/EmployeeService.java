package com.example.SpringBootApp.services;

import com.example.SpringBootApp.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service //Declares this class as a service serving business logic. Services
// are singletons that create the instance of the class and registers it at startup

public class EmployeeService {


    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = Arrays.asList(
                new Employee(1,"John","Texas"),
                new Employee(2, "Amy", "Kansas"),
                new Employee(3, "Peter", "Colorado"),
                new Employee(4, "Josh", "New Mexico"),
                new Employee(5, "Tracy", "Washington DC")
        );
        return employeeList;
    }
    } // Now the business logic, that is adding employees is going in the service
// class instead of the controller. Sort of like an action method in .NET
