package com.example.v1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employee_salary")
public class EmployeeSalary extends BaseModel {
	@Column(name = "base_amount")
	private BigDecimal baseAmount;
	@Column(name = "hra")
	private BigDecimal hra;
	@Column(name = "pf")
	private BigDecimal pf;
	@Column(name = "medical")
	private BigDecimal medical;
	@Column(name = "tax")
	private BigDecimal tax;
	@Column(name = "total_amount")
	private BigDecimal totalAmount;
	@OneToOne
	@JoinColumn(name = "employee_id", nullable = false)
	@JsonBackReference
	private EmployeeModel employee;

	public EmployeeSalary() {
	}

	public EmployeeSalary(BigDecimal baseAmount, BigDecimal hra, BigDecimal pf, BigDecimal medical, BigDecimal tax, BigDecimal totalAmount, EmployeeModel employee) {
		this.baseAmount = baseAmount;
		this.hra = hra;
		this.pf = pf;
		this.medical = medical;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.employee = employee;
	}

	public BigDecimal getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}

	public BigDecimal getHra() {
		return hra;
	}

	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}

	public BigDecimal getPf() {
		return pf;
	}

	public void setPf(BigDecimal pf) {
		this.pf = pf;
	}

	public BigDecimal getMedical() {
		return medical;
	}

	public void setMedical(BigDecimal medical) {
		this.medical = medical;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeSalary{" +
				"baseAmount=" + baseAmount +
				", hra=" + hra +
				", pf=" + pf +
				", medical=" + medical +
				", tax=" + tax +
				", totalAmount=" + totalAmount +
				", employee=" + employee +
				", id=" + id +
				'}';
	}
}
