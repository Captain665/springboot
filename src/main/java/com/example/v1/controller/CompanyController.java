package com.example.v1.controller;

import com.example.v1.common.ApiFailure;
import com.example.v1.common.ApiResponse;
import com.example.v1.common.ApiSuccess;
import com.example.v1.common.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CompanyController {

	@GetMapping("/company/{id}/details")
	public ResponseEntity<ApiResponse> getDetails(@PathVariable Long id) {
		return new ResponseEntity<>(new ApiFailure("test", new ErrorCode(id.toString(), "test_id", "test")), HttpStatus.BAD_REQUEST);
	}
}
