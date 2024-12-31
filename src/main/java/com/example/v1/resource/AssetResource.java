package com.example.v1.resource;

import com.example.v1.model.AssetModel;

public class AssetResource {
	public Long id;
	public String type;
	public String name;
	public String quantity;
	public String description;
	public String price;

	public AssetResource() {
	}

	public AssetResource(AssetModel model) {
		this.id = model.getId();
		this.type = model.getType();
		this.name = model.getName();
		this.quantity = model.getQuantity();
		this.description = model.getDescription();
		this.price = model.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "AssetResource{" +
				"id=" + id +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				", quantity='" + quantity + '\'' +
				", description='" + description + '\'' +
				", price='" + price + '\'' +
				'}';
	}
}
