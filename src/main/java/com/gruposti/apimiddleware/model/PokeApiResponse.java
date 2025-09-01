package com.gruposti.apimiddleware.model;

public class PokeApiResponse {
	private Integer count;
	private String next;
	private String previus;
	private CharacterSimpleInfo[] results;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevius() {
		return previus;
	}
	public void setPrevius(String previus) {
		this.previus = previus;
	}
	public CharacterSimpleInfo[] getResults() {
		return results;
	}
	public void setResults(CharacterSimpleInfo[] results) {
		this.results = results;
	}
	
	
}
