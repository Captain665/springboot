package com.example.v1.common;

import com.example.v1.enums.Status;

public class ApiUnauthorized extends ApiResponse {
	public ApiUnauthorized(Object error) {
		super(Status.unauthorized, "you are not authorized to access this", null, error);
	}
}
