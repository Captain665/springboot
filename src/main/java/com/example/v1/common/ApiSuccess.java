package com.example.v1.common;

import com.example.v1.enums.Status;

public class ApiSuccess extends ApiResponse {

	public ApiSuccess(Object result) {
		super(Status.success, "", result, null);
	}
}
