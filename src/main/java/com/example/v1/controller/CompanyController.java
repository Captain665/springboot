package com.example.v1.controller;

import com.example.v1.common.ApiFailure;
import com.example.v1.common.ApiResponse;
import com.example.v1.common.ApiSuccess;
import com.example.v1.common.ErrorCode;
import com.example.v1.resource.CompanyResponseResource;
import com.example.v1.services.CompanyServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CompanyController {
	private final CompanyServiceImp service;
	private final Logger logger = LoggerFactory.getLogger("v1.companyController");

	@Autowired
	public CompanyController(CompanyServiceImp service) {
		this.service = service;
	}


	@GetMapping("/company/{id}/details")
	public ResponseEntity<ApiResponse> getDetails(@PathVariable Long id) {
		logger.info("company id : " + id);
		CompanyResponseResource response = service.getCompanyDetails(id);
		if (response != null) {
			logger.info("response : " + response);
			return new ResponseEntity<>(new ApiSuccess(response), HttpStatus.OK);
		}

		logger.info("error : " + "company id not found");
		return new ResponseEntity<>(
				new ApiFailure("Company id is not found", new ErrorCode("25", "COMPANY_ID", "Incorrect Company id")),
				HttpStatus.BAD_REQUEST);
	}
}
