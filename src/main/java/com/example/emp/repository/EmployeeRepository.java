package com.example.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
