package com.gruposti.apimiddleware.model;

public class DataGenericResponse {
	private String type;
	private String action;
	private PokeApiResponse data;
	
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
	public PokeApiResponse getData() {
		return data;
	}
	public void setData(PokeApiResponse data) {
		this.data = data;
	}

}
