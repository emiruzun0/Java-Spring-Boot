package com.emirhanuzun.springboot.thymeleafdemo.dao;

import com.emirhanuzun.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // Add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

}
