package com.emirhanuzun.springboot.cruddemo.dao;

import com.emirhanuzun.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);


}
