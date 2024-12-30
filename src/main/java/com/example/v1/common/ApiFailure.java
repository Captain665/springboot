package com.example.v1.common;

import com.example.v1.enums.Status;

public class ApiFailure extends ApiResponse {
	public ApiFailure(String message, Object error) {
		super(Status.failure, message, null, error);
	}
}
