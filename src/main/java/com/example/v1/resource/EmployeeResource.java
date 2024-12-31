package com.example.v1.resource;

import com.example.v1.enums.Gender;
import com.example.v1.model.AssetModel;
import com.example.v1.model.EmployeeModel;
import com.example.v1.model.EmployeeSalary;

import java.time.LocalDateTime;
import java.util.List;

public class EmployeeResource {
	public Long id;
	public LocalDateTime createdAt;
	public String createdBy;
	public LocalDateTime updatedAt;
	public String updatedBy;
	public String fullName;
	public String mobile;
	public String emailId;
	public Gender gender;
	public String joiningDate;
	public String resignDate;
	public String role;
	public String location;
	public Long companyId;
	public List<AssetModel> assets;
	public Object companyDetails;
	public EmployeeSalary salaryStructure;


	public EmployeeResource(EmployeeModel model) {
		this.id = model.getId();
		this.createdAt = model.getCreatedAt();
		this.createdBy = model.getCreatedBy();
		this.updatedAt = model.getUpdatedAt();
		this.updatedBy = model.getUpdatedBy();
		this.fullName = model.getFullName();
		this.mobile = model.getMobile();
		this.emailId = model.getEmailId();
		this.gender = model.getGender();
		this.joiningDate = model.getJoiningDate();
		this.resignDate = model.getResignDate();
		this.role = model.getRole();
		this.location = model.getLocation();
		this.companyDetails = model.getCompany();
		this.assets = model.getAssets();
		this.salaryStructure = model.getSalary();
	}

	public EmployeeResource() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getResignDate() {
		return resignDate;
	}

	public void setResignDate(String resignDate) {
		this.resignDate = resignDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public List<AssetModel> getAssets() {
		return assets;
	}

	public void setAssets(List<AssetModel> assets) {
		this.assets = assets;
	}

	public Object getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(Object companyDetails) {
		this.companyDetails = companyDetails;
	}

	public EmployeeSalary getSalaryStructure() {
		return salaryStructure;
	}

	public void setSalaryStructure(EmployeeSalary salaryStructure) {
		this.salaryStructure = salaryStructure;
	}

	@Override
	public String toString() {
		return "EmployeeResource{" +
				"id=" + id +
				", createdAt=" + createdAt +
				", createdBy='" + createdBy + '\'' +
				", updatedAt=" + updatedAt +
				", updatedBy='" + updatedBy + '\'' +
				", fullName='" + fullName + '\'' +
				", mobile='" + mobile + '\'' +
				", emailId='" + emailId + '\'' +
				", gender=" + gender +
				", joiningDate='" + joiningDate + '\'' +
				", resignDate='" + resignDate + '\'' +
				", role='" + role + '\'' +
				", location='" + location + '\'' +
				", companyId=" + companyId +
				'}';
	}
}
