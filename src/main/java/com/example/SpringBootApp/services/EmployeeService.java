package com.example.SpringBootApp.services;

import com.example.SpringBootApp.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service //Declares this class as a service serving business logic. Services
// are singletons that create the instance of the class and registers it at startup

public class EmployeeService {

    List<Employee> employeeList = new ArrayList<Employee>(Arrays.asList(
            new Employee(1,"John","Texas"),
            new Employee(2, "Amy", "Kansas"),
            new Employee(3, "Peter", "Colorado"),
            new Employee(4, "Josh", "New Mexico"),
            new Employee(5, "Tracy", "Washington DC")));
    public List<Employee> getAllEmployees()
    {
        return employeeList;
    }
    public Employee GetEmployee(int id)
    {
        return  employeeList.stream().filter(employee -> employee.getEmployeeId() == id).findFirst().get();
    }
    public void CreateEmployee(Employee employee)
    {
        employeeList.add(employee); //TODO: Add it with DB
    }
    public void updateEmployee(Employee employee)
    {
       List<Employee> tempEmployees = new ArrayList<>();
       for(Employee emp : employeeList)
       {
            if(emp.getEmployeeId() == employee.getEmployeeId())
            {
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployees.add(emp);
       }
       this.employeeList= tempEmployees;
    }
    public void deleteEmployee(int id)
    {
      Employee emp=  employeeList.stream().filter(employee -> employee.getEmployeeId() == id).findFirst().get();
      employeeList.remove(emp);
    }
    } // Now the business logic, that is adding employees is going in the service
// class instead of the controller. Sort of like a service class in .NET
