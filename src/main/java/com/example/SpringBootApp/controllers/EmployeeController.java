package com.example.SpringBootApp.controllers;

import com.example.SpringBootApp.entities.Employee;
import com.example.SpringBootApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/employees/{id}") // Flower brackets indicate that the id is variable and will be picked up by the path variable annotation if added as a parameter
    public Employee GetEmployee(@PathVariable int id) //Path Variable allows us to
    // pass variable values from code to the endpoint and it identifies the variable
    // type we are going to pass with that of the API endpoint.
    {
        return employeeService.GetEmployee(id);
    }
    @RequestMapping(value = "/employees", method = RequestMethod.POST) // To add a post request,
    // we need to add a method called Post with the RequestMethod enum,
    // very much like form tag but there we add it as string
    public void CreateEmployee(@RequestBody Employee employee) // RequestBody
    // annotation is going to get the employee details from the request body that
    // we are going to pass to the API externally, for now in Postman.
    {
        employeeService.CreateEmployee(employee);
    }
}
