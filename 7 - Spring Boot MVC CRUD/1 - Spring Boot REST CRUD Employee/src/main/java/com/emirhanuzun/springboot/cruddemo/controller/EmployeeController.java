package com.emirhanuzun.springboot.cruddemo.controller;

import com.emirhanuzun.springboot.cruddemo.entity.Employee;
import com.emirhanuzun.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;


    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // Add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        // Get the employees from db
        List<Employee> theEmployees = employeeService.findAll();
        System.out.println(theEmployees);

        // Add to the spring model
        theModel.addAttribute("employees",theEmployees);

        return "list-employees";
    }


}
