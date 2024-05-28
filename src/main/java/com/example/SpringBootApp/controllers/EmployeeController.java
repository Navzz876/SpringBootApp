package com.example.SpringBootApp.controllers;

import com.example.SpringBootApp.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

//@Controller - Annotates the class is a controller
//@ResponseBody - Employee controller return result is the response of the URL
@RestController // Combination of Controller and response body in one annotation
public class EmployeeController {
    public List<Employee> employeeList;
    @RequestMapping("/employees") // Get Request(default) to the endpoint of employees
    public List<Employee> GetAllEmployees(){
       employeeList = Arrays.asList(
               new Employee(1,"John","Texas"),
               new Employee(2, "Amy", "Kansas"),
               new Employee(3, "Peter", "Colorado"),
               new Employee(4, "Josh", "New Mexico"),
        new Employee(5, "Tracy", "Washington DC")

       );
        return employeeList;
    }
}
