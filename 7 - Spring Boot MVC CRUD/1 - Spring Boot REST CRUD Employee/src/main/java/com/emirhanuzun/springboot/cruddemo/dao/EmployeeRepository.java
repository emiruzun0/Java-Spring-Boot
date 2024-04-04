package com.emirhanuzun.springboot.cruddemo.dao;

import com.emirhanuzun.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
