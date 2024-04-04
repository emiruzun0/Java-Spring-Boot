package com.emirhanuzun.springboot.thymeleafdemo.controller;

import com.emirhanuzun.springboot.thymeleafdemo.entity.Employee;
import com.emirhanuzun.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        // Add to the spring model
        theModel.addAttribute("employees",theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Employee theEmployee = new Employee();

        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

        // Get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // Set the employee in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);

        // Send over to the form
        return "employees/employee-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId,Model theModel){

        // Delete the employee
        employeeService.deleteById(theId);

        //redirect to the /employees/list
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }


}
