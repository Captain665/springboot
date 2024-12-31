package com.example.v1.repository;

import com.example.v1.model.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<EmployeeSalary, Long> {

}
