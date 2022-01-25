package com.exceptionhandling.response;

import org.springframework.http.HttpStatus;

public class APIResponse<T> {

	int recordCount;
	HttpStatus status;
	T response;
	
	
	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public APIResponse() {

	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public APIResponse(int recordCount,HttpStatus status,T response) {
		this.recordCount = recordCount;
		this.status = status;
		this.response = response;
	}

	

}
