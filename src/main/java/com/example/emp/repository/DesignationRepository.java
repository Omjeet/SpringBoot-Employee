package com.example.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emp.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer>{

}
