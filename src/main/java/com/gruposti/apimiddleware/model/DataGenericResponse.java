package com.gruposti.apimiddleware.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataGenericResponse<T> {
	private String type;
	private String action;
	private T data;
	private String message;
	private String code;
	
	public DataGenericResponse() {}
	
	public DataGenericResponse(String type, String action, T data, String message, String code) {
		this.type = type;
		this.action = action;
		this.data = data;
		this.message = message;
		this.code = code;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
