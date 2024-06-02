package com.example.SpringBootApp.controllers;

import com.example.SpringBootApp.entities.Employee;
import com.example.SpringBootApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
     // Autowired is going to check if there is any dependencies related to both the classes with the spring boot registry and add them here, so here for
    // example autowired is going to identify the employee service class which is registered as a service and it looks into the service
    // registry to check if the instance has been created for the service and if the instance is created it will automatically load that
    // instance of the service object and assign it to the variable we have defined of the type EmployeeService.
     @Autowired
    EmployeeService employeeService; // Instance of employee service was
    // created and we are just using that singleton here and not re-creating a new
    // instance.
    @RequestMapping("/employees") // Get Request(default) to the endpoint of employees
    public List<Employee> GetAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
