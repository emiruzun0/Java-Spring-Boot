package com.emirhanuzun.springboot.thymeleafdemo.dao;

import com.emirhanuzun.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
