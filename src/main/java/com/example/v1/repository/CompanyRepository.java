package com.example.v1.repository;

import com.example.v1.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

	public Optional<CompanyModel> findById(Long id);
}
