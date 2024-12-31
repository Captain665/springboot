package com.example.v1.services;

import com.example.v1.model.CompanyModel;
import com.example.v1.model.EmployeeModel;
import com.example.v1.model.EmployeeSalary;
import com.example.v1.repository.AssetRepository;
import com.example.v1.repository.CompanyRepository;
import com.example.v1.repository.EmployeeRepository;
import com.example.v1.resource.EmployeeBuilder;
import com.example.v1.resource.EmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class EmployeeService {
	private final EmployeeRepository repository;
	private final CompanyRepository companyRepository;
	private final AssetRepository assetRepository;

	@Autowired
	public EmployeeService(EmployeeRepository repository, CompanyRepository companyRepository, AssetRepository assetRepository) {
		this.repository = repository;
		this.companyRepository = companyRepository;
		this.assetRepository = assetRepository;
	}

	@Transactional
	public EmployeeResource createOrUpdate(EmployeeResource resource) {
		Optional<CompanyModel> companyModel = companyRepository.findById(resource.getCompanyId());
		if (companyModel.isEmpty()) {
			return null;
		}
		EmployeeModel employeeModel = resourceToModel(resource, companyModel.get());
		Optional<EmployeeModel> modelInDb = repository.findByMobile(employeeModel.getMobile());
		return modelInDb.map(model -> updateEmployeeModel(model, employeeModel, companyModel.get()))
				.orElseGet(() -> saveEmployeeModel(employeeModel, companyModel.get()));
	}

	private EmployeeSalary calculateEmployeeSalary(EmployeeSalary employeeSalary) {
		BigDecimal baseAmount = employeeSalary.getBaseAmount() != null ? employeeSalary.getBaseAmount() : BigDecimal.ZERO;
		BigDecimal hra = employeeSalary.getHra() != null ? employeeSalary.getHra() : BigDecimal.ZERO;
		BigDecimal pf = employeeSalary.getPf() != null ? employeeSalary.getPf() : BigDecimal.ZERO;
		BigDecimal medical = employeeSalary.getMedical() != null ? employeeSalary.getMedical() : BigDecimal.ZERO;
		BigDecimal tax = employeeSalary.getTax() != null ? employeeSalary.getTax() : BigDecimal.ZERO;
		BigDecimal totalAmount = baseAmount.add(hra).add(pf).add(medical).subtract(tax);
		employeeSalary.setTotalAmount(totalAmount);
		return employeeSalary;
	}

	private EmployeeModel resourceToModel(EmployeeResource resource, CompanyModel companyModel) {
		return new EmployeeBuilder()
				.setFullName(resource.getFullName())
				.setMobile(resource.getMobile())
				.setEmailId(resource.getEmailId())
				.setGender(resource.getGender())
				.setJoiningDate(resource.getJoiningDate())
				.setResignDate(resource.getResignDate())
				.setRole(resource.getRole())
				.setLocation(resource.getLocation())
				.setCompany(companyModel)
				.setAssets(resource.getAssets())
				.setSalary(calculateEmployeeSalary(resource.getSalaryStructure()))
				.build();
	}

	private EmployeeResource saveEmployeeModel(EmployeeModel employeeModel, CompanyModel companyModel) {
		employeeModel.setActive(true);
		employeeModel.setNewUser(true);
		employeeModel.getSalary().setEmployee(employeeModel);
		employeeModel.getAssets().forEach(assetModel -> assetModel.setEmployee(employeeModel));
		EmployeeModel updatedEmployeeModel = repository.save(employeeModel);
		updatedEmployeeModel.setCompany(companyModel);
		return new EmployeeResource(updatedEmployeeModel);
	}

	private EmployeeResource updateEmployeeModel(EmployeeModel modelInDb, EmployeeModel employeeModel, CompanyModel companyModel) {
		modelInDb.getAssets().forEach(assetRepository::delete);
		employeeModel.setId(modelInDb.getId());
		employeeModel.getSalary().setEmployee(employeeModel);
		employeeModel.getSalary().setId(modelInDb.getSalary().getId());
		employeeModel.getAssets().forEach(assetModel -> assetModel.setEmployee(employeeModel));
		employeeModel.setActive(true);
		employeeModel.setNewUser(false);
		EmployeeModel updatedEmployeeModel = repository.save(employeeModel);
		updatedEmployeeModel.setCompany(companyModel);
		return new EmployeeResource(updatedEmployeeModel);
	}
}
