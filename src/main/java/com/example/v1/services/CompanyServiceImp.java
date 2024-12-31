package com.example.v1.services;

import com.example.v1.model.CompanyModel;
import com.example.v1.model.EmployeeModel;
import com.example.v1.repository.CompanyRepository;
import com.example.v1.repository.EmployeeRepository;
import com.example.v1.resource.CompanyResponseResource;
import com.example.v1.resource.EmployeeResponseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp {
	private final CompanyRepository companyRepository;
	private final EmployeeRepository employeeRepository;

	@Autowired
	public CompanyServiceImp(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
		this.companyRepository = companyRepository;
		this.employeeRepository = employeeRepository;
	}

	public CompanyResponseResource getCompanyDetails(Long companyId) {
		Optional<CompanyModel> model = companyRepository.findById(companyId);
		if (model.isPresent()) {
			CompanyResponseResource companyResponseResource = new CompanyResponseResource(model);
			List<EmployeeModel> employeeModel = employeeRepository.findByCompanyId(model.get().getId()).stream().filter(EmployeeModel::getActive).toList();
			companyResponseResource.setNumberOfEmployee(BigInteger.valueOf(employeeModel.size()));
			companyResponseResource.setEmployeeDetails(employeeModel.stream().map(EmployeeResponseResource::new).toList());
			return companyResponseResource;
		}
		return null;
	}
}
