package com.example.jersey_todo.payload;

public class ApiResponse {
	
	private String message;
	private boolean success;
	private Object obj;

	public ApiResponse(String message, boolean success) {
		this.message = message;
		this.success = success;
	}

	public ApiResponse(String message, boolean success, Object obj) {
		this.message = message;
		this.success = success;
		this.obj = obj;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "ApiResponse{" +
				"message='" + message + '\'' +
				", success=" + success +
				", obj=" + obj +
				'}';
	}
}
