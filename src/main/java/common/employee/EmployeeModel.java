package common.employee;

import common.base.BaseModel;
import common.enums.Gender;

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
