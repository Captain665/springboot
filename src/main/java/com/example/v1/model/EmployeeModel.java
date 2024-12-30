package com.example.v1.model;

import com.example.v1.model.BaseModel;
import com.example.v1.enums.Gender;

import java.time.LocalDateTime;

public class EmployeeModel extends BaseModel {
	public String fullName;
	public String mobile;
	public String email;
	public String role;
	public Gender gender;
	public LocalDateTime joiningDate;
	public LocalDateTime resignDate;

}
