package com.example.v1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "company_assets")
public class AssetModel extends BaseModel {
	@Column(name = "type")
	private String type;
	@Column(name = "name")
	private String name;
	@Column(name = "quantity")
	private String quantity;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private String price;
	@ManyToOne(optional = false)
	@JoinColumn(name = "employee_id", nullable = false)
	@JsonBackReference
	private EmployeeModel employee;

	public AssetModel() {
	}

	public AssetModel(String type, String name, String quantity, String description, String price, EmployeeModel employee) {
		this.type = type;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
		this.employee = employee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AssetModel{" +
				"type='" + type + '\'' +
				", name='" + name + '\'' +
				", quantity='" + quantity + '\'' +
				", description='" + description + '\'' +
				", price='" + price + '\'' +
				", employee=" + employee +
				", id=" + id +
				'}';
	}
}
