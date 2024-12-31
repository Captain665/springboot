package com.example.v1.controller;

import com.example.v1.common.ApiFailure;
import com.example.v1.common.ApiResponse;
import com.example.v1.common.ApiSuccess;
import com.example.v1.common.ErrorCode;
import com.example.v1.resource.EmployeeResource;
import com.example.v1.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

	private final EmployeeService service;
	private final Logger logger = LoggerFactory.getLogger("v1.employee.controller");

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping("/employee")
	public ResponseEntity<ApiResponse> create(@RequestBody EmployeeResource resource) {
		logger.info(" json : " + resource);
		EmployeeResource response = service.createOrUpdate(resource);
		if (response == null) {
			logger.info("Incorrect company id");
			return new ResponseEntity<>(
					new ApiFailure("Incorrect company id",
							new ErrorCode("error", "COMPANY_ID", "Incorrect company id")),
					HttpStatus.OK);
		}
		logger.info(" response : " + response);
		return new ResponseEntity<>(new ApiSuccess(response), HttpStatus.OK);
	}

}
