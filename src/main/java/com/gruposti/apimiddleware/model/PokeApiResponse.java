package com.gruposti.apimiddleware.model;

public class PokeApiResponse {
	private Integer items;
	private CharacterSimpleInfo[] results;
	

	public CharacterSimpleInfo[] getResults() {
		return results;
	}
	public void setResults(CharacterSimpleInfo[] results) {
		this.results = results;
	}
	public Integer getItems() {
		return items;
	}
	public void setItems(Integer items) {
		this.items = items;
	}
	
	
}
