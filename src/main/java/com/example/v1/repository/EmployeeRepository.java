package com.example.v1.repository;

import com.example.v1.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

	public List<EmployeeModel> findByCompanyId(Long id);
}
