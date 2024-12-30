package com.example.v1.common;

public class ErrorCode {
	public String traceId;
	public String code;
	public String message;

	public ErrorCode() {
	}

	public ErrorCode(String traceId, String code, String message) {
		this.traceId = traceId;
		this.code = code;
		this.message = message;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
